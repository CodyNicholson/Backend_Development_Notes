package myproject.model;

import java.awt.Color;
import java.util.ArrayList;

/**
 * A light has a boolean state.
 */
public class Light implements Agent {
	Light() { } // Created only by this package
	
	private ArrayList<Car> observers = new ArrayList<>();
	private Color c = Color.green;
	
	private void notifyCars(double time)
	{
		for(Car c : observers)
		{
			c.notifyCar(time);
		}
	}

	public Color getColor()
	{
		return c;
	}
	
	public void addObservingCar(Car c)
	{
		observers.add(c);
	}
	
	public void run(double time)
	{
		if (time%40==0) // replace conditional
		{
			notifyCars(time);
		}
	}

	public void setColor(Color color) {
		c = color;
	}
}

