package myproject.model;

import java.util.ArrayList;
import java.util.List;

/*
 * Made to organize the roads and move cars from one road to the next
 */

public class RoadController
{
	private List<Road> hRoadList = new ArrayList<Road>();
	private List<Road> vRoadList = new ArrayList<Road>();
	
	public RoadController(List<Road> hRoads, List<Road> vRoads)
	{
		hRoadList = hRoads;
		vRoadList = vRoads;
	}
	
	public Road getVRoad(int i)
	{
		return vRoadList.get(i);
	}
	
	public Road getHRoad(int i)
	{
		return hRoadList.get(i);
	}
	
	public void addCar(Car c, int roadIndex, Direction dir)
	{
		if(dir == Direction.horizontal)
		{
			if(roadIndex >= hRoadList.size())
			{
				roadIndex = 0;
			}
			Road currentRoad = getHRoad(roadIndex);
			currentRoad.accept(c);
			c.setRoadIndex(roadIndex);
			c.resetPosition();
		}
		else
		{
			if(roadIndex >= vRoadList.size())
			{
				roadIndex = 0;
			}
			Road currentRoad = getVRoad(roadIndex);
			currentRoad.accept(c);
			c.setRoadIndex(roadIndex);
			c.resetPosition();
		}
	}
	
	public void removeCar(Car c, int roadIndex, Direction dir)
	{
		if(dir == Direction.horizontal)
		{
			Road currentRoad = getHRoad(roadIndex);
			currentRoad.remove(c);
		}
		else
		{
			Road currentRoad = getVRoad(roadIndex);
			currentRoad.remove(c);
		}
	}
}
