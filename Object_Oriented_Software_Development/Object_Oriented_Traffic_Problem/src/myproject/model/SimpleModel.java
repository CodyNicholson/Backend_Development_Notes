package myproject.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Observable;
import myproject.util.Animator;

/**
 * An example to model for a simple visualization.
 * The model contains two roads.
 * See {@link #SimpleModel(AnimatorBuilder)}.
 */
public class SimpleModel extends Observable {
	private List<Agent> agents;
	private Animator animator;
	private boolean disposed;
	private double time;
	private RoadController rc;
	private static SimpleModel instance;

	/** Creates a model to be visualized using the <code>builder</code>.
	 *  If the builder is null, no visualization is performed.
	 *  Each road has one {@link Car}.
	 *
	 */
	public SimpleModel(AnimatorBuilder builder) {
		if (builder == null) {
			builder = new NullAnimatorBuilder();
		}
		instance = this;
		agents = new ArrayList<Agent>();
		setup(builder);
		animator = builder.getAnimator();
		super.addObserver(animator);
	}

	public static SimpleModel getModel()
	{
		return instance;
	}
	
	/**
	 * Run the simulation for <code>duration</code> model seconds.
	 */
	public void run(int duration) {
		if (disposed)
			throw new IllegalStateException();
		for (int i=0; i<duration; i++) {
			time++;
			Agent[] agents_copy = agents.toArray(new Agent[0]);
			for (Agent a : agents_copy) {
				a.run(time);
			}
			super.setChanged();
			super.notifyObservers();
		}
	}

	/**
	 * Throw away this model.
	 */
	public void dispose() {
		animator.dispose();
		disposed = true;
	}

	private void setup(AnimatorBuilder builder) {
		List<Road> hRoads = new ArrayList<Road>();
		List<Road> vRoads = new ArrayList<Road>();
		Road r1 = new Road();
		builder.addHorizontalRoad(r1, 0, 1, false, null, null);
		Car c = new Car(Direction.horizontal, 0);
		r1.accept(c);
		agents.add(c);
		Road r2 = new Road();
		builder.addHorizontalRoad(r2, 1, 1, false, null, null);
		hRoads.add(r1);
		hRoads.add(r2);
		
		rc = new RoadController(hRoads, vRoads);

		// Road oldroad = null;
		// for (int j = 0; j <= columns; j++) {
		//   Road newroad = new Road();
		//   builder.addHorizontalRoad(newroad, 0, (eastToWest? columns-j : j), eastToWest);
		//   newroad.setNext(oldroad);
		//   oldroad = newroad;
		// }
	}

	public void visitRoadController(Visitor v) {
		RoadControllerVisitor rcv = new RoadControllerVisitor(rc);
		v.visit(rcv);
		rcv.visit(v);		
	}
}
