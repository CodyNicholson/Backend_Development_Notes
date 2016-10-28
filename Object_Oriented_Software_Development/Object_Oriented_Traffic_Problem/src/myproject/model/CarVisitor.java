package myproject.model;

public class CarVisitor implements Visitor
{
	private Car c;
	
	public CarVisitor(Car c)
	{
		this.c = c;
	}

	@Override
	public void visit(Car c) {
		// Stop in front of idle cars
		
	}

	@Override
	public void visit(RoadController rc) {
		rc.removeCar(c, c.getRoadIndex(), c.getDirection());
		rc.addCar(c, c.getRoadIndex()+1, c.getDirection());
	}

	@Override
	public void visit(Visitor v) {
		v.visit(c);
	}

}
