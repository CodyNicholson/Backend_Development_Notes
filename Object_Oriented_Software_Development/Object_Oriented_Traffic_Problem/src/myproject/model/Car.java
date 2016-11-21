package myproject.model;

/**
 * A car remembers its position from the beginning of its road.
 * Cars have random velocity and random movement pattern:
 * when reaching the end of a road, the dot either resets its position
 * to the beginning of the road, or reverses its direction.
 */
public class Car implements Agent
{
	private double position = 0;
	private double velocity = (Math.random() * (MP.carVelocityMax - MP.carVelocityMin) + MP.carVelocityMin);
	private java.awt.Color color = new java.awt.Color((int)Math.ceil(Math.random()*255),(int)Math.ceil(Math.random()*255),(int)Math.ceil(Math.random()*255));
	private Direction dir = Direction.horizontal; // horizontal is true, vertical is false
	private int roadIndex = 0;
//	private double brakeDistance =  (Math.random() * (ModelParameters.carStopDistanceMax - ModelParameters.carStopDistanceMin) + ModelParameters.carStopDistanceMin);
	private double stopDistance = (Math.random() * (MP.carBrakeDistanceMax - MP.carBrakeDistanceMin) + MP.carBrakeDistanceMin);
	public double speed = 1;
	private CarState state = new CarState(null, null);
	
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
	
	public double getStopDistance()
	{
		return this.stopDistance;
	}
	
	public double getVelocity()
	{
		return this.velocity;
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
	
	public void run(double time)
	{
		state.run(this);
		if ((position + velocity*speed) > (MP.roadLength-MP.carLength))
		{
			CarVisitor cv = new CarVisitor(this);
			Model.getModel().visitRoadController(cv);
		}
		position += velocity*speed;
	}

	public CarState getState() {
		return state;
	}

	public void setState(CarState state) {
		this.state = state;
	}
}
