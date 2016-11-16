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
		cars.add(d);
	}
	
	public void remove(Car d) {
		if (d == null) { throw new IllegalArgumentException(); }
		cars.remove(d);
	}
	
	public List<Car> getCars() {
		return cars;
	}
}
