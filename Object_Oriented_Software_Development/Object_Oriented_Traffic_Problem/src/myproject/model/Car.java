package myproject.model;

import java.awt.Color;

/**
 * A car remembers its position from the beginning of its road.
 * Cars have random velocity and random movement pattern:
 * when reaching the end of a road, the dot either resets its position
 * to the beginning of the road, or reverses its direction.
 */
public class Car implements Agent, LightObserver{

	private double position = 0;
	private double velocity = (int) (Math.random() * (ModelParameters.carVelocityMin - ModelParameters.carVelocityMax) + ModelParameters.carVelocityMin);
	private java.awt.Color color = new java.awt.Color((int)Math.ceil(Math.random()*255),(int)Math.ceil(Math.random()*255),(int)Math.ceil(Math.random()*255));
	private Direction dir = Direction.horizontal; // horizontal is true, vertical is false
	private int roadIndex = 0;
//	private int brakeDistance =  (int) (Math.random() * (ModelParameters.carStopDistanceMin - ModelParameters.carStopDistanceMax) + ModelParameters.carStopDistanceMin);
//	private int stopDistance = (int) (Math.random() * (ModelParameters.carBrakeDistanceMin - ModelParameters.carBrakeDistanceMax) + ModelParameters.carBrakeDistanceMin);
	
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

	@Override
	public void notifyCar(double time, Light l)
	{
		//Implementation for car based on light state
		if(l.getColor() == Color.red)
		{
			this.velocity = 0;
		}
		else if(l.getColor() == Color.yellow)
		{
			this.velocity = 0;
		}
		else if(this.velocity == 0)
		{
			this.velocity = (int) Math.ceil(Math.random() * MP.maxVelocity);
		}
		else
		{
			//Do nothing, the light is green
		}
	}
	
	public void run(double time)
	{
		if ((position + velocity) > (MP.roadLength-MP.carLength))
		{
			CarVisitor cv = new CarVisitor(this);
			Model.getModel().visitRoadController(cv);
		}
		position += velocity;
	}
	
	// Make a carAccept interface to provide an accept method for the different things that need to accept the car (Roads, intersections, sink)
}
