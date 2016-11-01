package myproject.model;

/**
 * A car remembers its position from the beginning of its road.
 * Cars have random velocity and random movement pattern:
 * when reaching the end of a road, the dot either resets its position
 * to the beginning of the road, or reverses its direction.
 */
public class Car implements Agent {

	private double position = 0;
	private double velocity = (int) Math.ceil(Math.random() * MP.maxVelocity);
	private java.awt.Color color = new java.awt.Color((int)Math.ceil(Math.random()*255),(int)Math.ceil(Math.random()*255),(int)Math.ceil(Math.random()*255));
	private Direction dir = Direction.horizontal; // horizontal is true, vertical is false
	private int roadIndex = 0;
	
	public Car(Direction dir, int rIndex)
	{
		this.dir = dir;
		roadIndex = rIndex;
	}
			
	public double getPosition() {
		return position;
	}
	
	public void resetPosition()
	{
		this.position = 0;
	}
	
	public java.awt.Color getColor() {
		return color;
	}
	
	public Direction getDirection()
	{
		return this.dir;
	}
	
	public int getRoadIndex()
	{
		return this.roadIndex;
	}
	
	public void setRoadIndex(int i)
	{
		this.roadIndex = i;
	}
	
	public void notifyCar(double time)
	{
		run(time);
	}
	
	public void run(double time)
	{
		if ((position + velocity) > (MP.roadLength-MP.carLength))
		{
//			if(Light.)
//			{
//				
//			}
			CarVisitor cv = new CarVisitor(this);
			Model.getModel().visitRoadController(cv);
		}
		position += velocity;
	}
}
