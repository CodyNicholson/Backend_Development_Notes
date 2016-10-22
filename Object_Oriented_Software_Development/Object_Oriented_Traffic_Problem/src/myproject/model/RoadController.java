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
	
}
