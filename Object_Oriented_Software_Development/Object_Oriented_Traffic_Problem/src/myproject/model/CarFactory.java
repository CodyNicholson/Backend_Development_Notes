package myproject.model;

public class CarFactory
{
	private double position = 0;
	private double velocity = (int) Math.ceil(Math.random() * MP.maxVelocity);
	private java.awt.Color color = new java.awt.Color((int)Math.ceil(Math.random()*255),(int)Math.ceil(Math.random()*255),(int)Math.ceil(Math.random()*255));
	private Direction dir = Direction.horizontal; // horizontal is true, vertical is false
	private int roadIndex = 0;
	
	public static Car createCar(Direction dir, int rIndex)
	{
		Car c = new Car(dir, rIndex);
		return c;
	}
}
