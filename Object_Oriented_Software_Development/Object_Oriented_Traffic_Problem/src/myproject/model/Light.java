package myproject.model;

import java.awt.Color;
import java.util.ArrayList;

/**
 * A light has a boolean state.
 */
public class Light implements Agent {
	Light() { } // Created only by this package
	
	private ArrayList<Car> observers = new ArrayList<>();
	private Color clr = Color.green;
	
	public void notifyAllCars(double time, Light li)
	{
		for(Car c : observers)
		{
			c.notifyCar(time, this);
		}
	}
	
	public void subscribeCar(Car c)
	{
		observers.add(c);
	}
	
	public void unsubscribeCar(Car c)
	{
		observers.remove(c);
	}

	public Color getColor()
	{
		return clr;
	}
	
	public void addObservingCar(Car c)
	{
		observers.add(c);
	}
	
	public void run(double time)
	{
		if (time%40==0) // replace conditional
		{
			notifyAllCars(time, this);
		}
	}

	public void setColor(Color color, double time, Light li) {
		clr = color;
		notifyAllCars(time, this);
	}
}

