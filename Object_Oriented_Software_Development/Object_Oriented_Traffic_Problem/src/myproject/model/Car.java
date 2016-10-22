package myproject.model;

/**
 * A car remembers its position from the beginning of its road.
 * Cars have random velocity and random movement pattern:
 * when reaching the end of a road, the dot either resets its position
 * to the beginning of the road, or reverses its direction.
 */
public class Car implements Agent {

	private boolean backAndForth = Math.round(Math.random())==1 ? true : false;
	private double position = 0;
	private double velocity = (int) Math.ceil(Math.random() * MP.maxVelocity);
	private java.awt.Color color = new java.awt.Color((int)Math.ceil(Math.random()*255),(int)Math.ceil(Math.random()*255),(int)Math.ceil(Math.random()*255));
	private boolean horizontal = false; // horizontal is true, vertical is false
	private int roadIndex = 0;
	
	public Car(boolean h, int rIndex)
	{
		horizontal = h;
		roadIndex = rIndex;
	}
			
	public double getPosition() {
		return position;
	}
	public java.awt.Color getColor() {
		return color;
	}
	public void run(double time) {
		if (backAndForth) {
			if (((position + velocity) < 0) || ((position + velocity) > (MP.roadLength-MP.carLength)))
				velocity *= -1;
				
		} else {
			if ((position + velocity) > (MP.roadLength-MP.carLength))
				position = 0;
		}
		position += velocity;
	}
}
