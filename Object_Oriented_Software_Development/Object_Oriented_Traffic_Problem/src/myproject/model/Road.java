package myproject.model;

import java.util.List;
import java.util.ArrayList;

/**
 * A road holds cars.
 */
public class Road implements CarAccepter 
{
	Road() { } // Created only by this package
	
	private Road forwardRoad;
	private Road backwardRoad;
	private Light forwardLight;
	private Light backwardLight;
	private List<Car> cars = new ArrayList<Car>();

	public Road(Road forwardRoad, Road backwardRoad)
	{
		this.forwardRoad = forwardRoad;
		this.backwardRoad = backwardRoad;
	}
	
	public Road getForwardRoad()
	{
		return forwardRoad;
	}
	
	public Road getBackwardRoad()
	{
		return backwardRoad;
	}
	
	public void accept(Car d) {
		if (d == null) { throw new IllegalArgumentException(); }
		d.getState().setNextCar(getClosestCar());
		d.getState().setNextLight(getForwardLight());
		cars.add(d);
		if(this.forwardLight != null)
		{
			this.forwardLight.subscribeCar(d);
		}
	}
	
	public void remove(Car d) {
		if (d == null) { throw new IllegalArgumentException(); }
		cars.remove(d);
		if(this.forwardLight != null)
		{
			this.forwardLight.unsubscribeCar(d);
		}
	}
	
	public List<Car> getCars() {
		return cars;
	}
	
	public Car getClosestCar()
	{
		if(cars.isEmpty())
			return null;
		Car closestCar = cars.get(0);
		for(int i = 1; i < cars.size(); i++)
		{
			if(cars.get(i).getPosition() < closestCar.getPosition())
			{
				closestCar = cars.get(i);
			}
		}
		return closestCar;
	}

	public Light getForwardLight() {
		return forwardLight;
	}

	public void setForwardLight(Light forwardLight) {
		this.forwardLight = forwardLight;
	}

	public Light getBackwardLight() {
		return backwardLight;
	}

	public void setBackwardLight(Light backwardLight) {
		this.backwardLight = backwardLight;
	}
}
