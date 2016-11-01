package myproject.model;

import java.util.ArrayList;

/**
 * A light has a boolean state.
 */
public class Light implements Agent {
	Light() { } // Created only by this package
	
	private ArrayList<Car> observers = new ArrayList<>();
	private boolean state;
	
	private void notifyCars(double time)
	{
		for(Car c : observers)
		{
//			Car.notifyCar(time);
		}
	}

	public boolean getState() {
		return state; // implement state pattern to change lights, has four different states
	}
	
	public void addObservingCar(Car c)
	{
		observers.add(c);
	}
	
	public void run(double time) {
		if (time%40==0) { // remove, does not make sense
			state = !state;
			notifyCars(time);
		}
	}
}

