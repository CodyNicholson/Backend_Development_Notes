package myproject.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Observable;
import myproject.util.Animator;

/**
 * An example to model for a simple visualization.
 * The model contains roads organized in a matrix.
 * See {@link #Model(AnimatorBuilder, int, int)}.
 */
public class Model extends Observable {
	private List<Agent> agents;
	private Animator animator;
	private boolean disposed;
	private double time;
	private RoadController rc;
	private static Model instance;
	private IntersectionManager im;

	/** Creates a model to be visualized using the <code>builder</code>.
	 *  If the builder is null, no visualization is performed.
	 *  The number of <code>rows</code> and <code>columns</code>
	 *  indicate the number of {@link Light}s, organized as a 2D
	 *  matrix.  These are separated and surrounded by horizontal and
	 *  vertical {@link Road}s.  For example, calling the constructor with 1
	 *  row and 2 columns generates a model of the form:
	 *  <pre>
	 *     |  |
	 *   --@--@--
	 *     |  |
	 *  </pre>
	 *  where <code>@</code> is a {@link Light}, <code>|</code> is a
	 *  vertical {@link Road} and <code>--</code> is a horizontal {@link Road}.
	 *  Each road has one {@link Car}.
	 *
	 *  <p>
	 *  The {@link AnimatorBuilder} is used to set up an {@link
	 *  Animator}.
	 *  {@link AnimatorBuilder#getAnimator()} is registered as
	 *  an observer of this model.
	 *  <p>
	 */
	public Model(AnimatorBuilder builder, int rows, int columns)
	{
		if (rows < 0 || columns < 0 || (rows == 0 && columns == 0)) {
			throw new IllegalArgumentException();
		}
		instance = this;
		if (builder == null) {
			builder = new NullAnimatorBuilder();
		}
		this.agents = new ArrayList<Agent>();
		setup(builder, rows, columns);
		this.animator = builder.getAnimator();
		super.addObserver(animator);
	}
	
	public static Model getModel()
	{
		return instance;
	}
	
	public void addCar(Car c)
	{
		int roadIndex = 0;
		if(c.getDirection() == Direction.horizontal)
			roadIndex = (int) (Math.random() * (MP.gridRow)) * (MP.gridColumn + 2);
		else if(c.getDirection() == Direction.vertical)
			roadIndex = (int) (Math.random() * (MP.gridColumn)) * (MP.gridRow + 2);
		agents.add(c);
		rc.addCar(c, roadIndex, c.getDirection());
	}
	
	public void visitRoadController(Visitor v)
	{
		RoadControllerVisitor rcv = new RoadControllerVisitor(rc);
		v.visit(rcv);
		rcv.visit(v);
	}

	/**
	 * Run the simulation for <code>duration</code> model seconds.
	 */
	public void run(double duration) {
		if (disposed)
			throw new IllegalStateException();
		for (int i=0; i<duration; i++) {
			time++;
			// iterate through a copy because agents may change during iteration...
			for (Agent a : agents.toArray(new Agent[0])) {
				a.run(time);
			}
			super.setChanged();
			super.notifyObservers();
			im.update(time);
			CarFactory.updateTimedCarSpawn(time);
		}
	}

	/**
	 * Throw away this model.
	 */
	public void dispose() {
		animator.dispose();
		disposed = true;
	}
	
	public void removeAgent(Agent x)
	{
		agents.remove(x);
	}
	
	public Light getLightAt(int x, int y, Light[][] lights)
	{
		if(x < 0 || y < 0 || x >= lights.length || y >= lights[x].length)
		{
			return null;
		}
		return lights[x][y];
	}
	
	public void publicSetup(AnimatorBuilder builder, int rows, int columns)
	{
		setup(builder, rows, columns);
	}

	/**
	 * Construct the model, establishing correspondences with the visualizer.
	 */
	private void setup(AnimatorBuilder builder, int rows, int columns)
	{
		List<Road> hRoads = new ArrayList<Road>();
		List<Road> vRoads = new ArrayList<Road>();
		Light[][] intersections = new Light[columns][rows];
		Light forwardLight;

		// Add Lights
		for (int x=0; x<columns; x++)
		{
			for (int y=0; y<rows; y++)
			{
				Light l = new Light();
				l.debugX = x;
				l.debugY = y;
				intersections[x][y]=l;
				
				builder.addLight(intersections[x][y], y, x);
				agents.add(intersections[x][y]);
			}
		}
		
		//Setup Intersection Manager
		im = new IntersectionManager(intersections);

		// Add Horizontal Roads
		boolean eastToWest = false;
		for (int y=0; y<rows; y++)
		{
			if(!eastToWest)
			{
				for (int x1=0; x1 <= columns; x1++)
				{
					forwardLight = getLightAt(x1, y, intersections);
					Road l = new Road();
					builder.addHorizontalRoad(l, y, x1, eastToWest, forwardLight);
					l.setForwardLight(forwardLight);
					hRoads.add(l);
				}
				hRoads.add(new NullObjectRoad());
			}
			
			if(eastToWest)	
			{
				for (int x2=columns; x2 >= 0; x2--)
				{
					forwardLight = getLightAt(x2-1, y, intersections);
					Road l = new Road();
					builder.addHorizontalRoad(l, y, x2, eastToWest, forwardLight);
					l.setForwardLight(forwardLight);
					hRoads.add(l);
				}
				hRoads.add(new NullObjectRoad());
			}
			
			if(MP.trafficPattern == GridPattern.alternating)
				eastToWest = !eastToWest;
		}

		// Add Vertical Roads
		boolean southToNorth = false;
		for (int x=0; x<columns; x++)
		{
			if(!southToNorth)
			{
				for (int y1=0; y1 <= rows; y1++)
				{
					forwardLight = getLightAt(x, y1, intersections);
					Road l = new Road();
					System.out.println("NS "+y1+ (forwardLight != null? " F: "+forwardLight.debugX+" "+forwardLight.debugY : "NULL"));
					builder.addVerticalRoad(l, y1, x, southToNorth, forwardLight);
					l.setForwardLight(forwardLight);
					vRoads.add(l);
				}
				vRoads.add(new NullObjectRoad());
			}
			
			if(southToNorth)
			{
				for (int y2=rows; y2 >= 0; y2--)
				{
					forwardLight = getLightAt(x, y2-1, intersections);
					Road l = new Road();
					
					builder.addVerticalRoad(l, y2, x, southToNorth, forwardLight);
					l.setForwardLight(forwardLight);
					vRoads.add(l);
					System.out.println("SN "+y2+(forwardLight != null? " F: "+forwardLight.debugX+" "+forwardLight.debugY : "NULL"));
				}
				vRoads.add(new NullObjectRoad());
			}
			
			if(MP.trafficPattern == GridPattern.alternating)
				southToNorth = !southToNorth;
		}
		
		// Add Horizontal Cars
		for (int l = 0; l < hRoads.size(); l++) {
			Car car = CarFactory.createCar(Direction.horizontal, l);
			agents.add(car);
			hRoads.get(l).accept(car);
		}
		
		// Add Vertical Cars
		for (int l = 0; l < vRoads.size(); l++) {
			Car car = CarFactory.createCar(Direction.vertical, l);
			agents.add(car);
			vRoads.get(l).accept(car);
		}
		
		rc = new RoadController(hRoads, vRoads);
	}
}
