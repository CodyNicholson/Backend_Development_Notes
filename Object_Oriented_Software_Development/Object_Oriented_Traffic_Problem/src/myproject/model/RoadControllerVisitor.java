package myproject.model;

public class RoadControllerVisitor  implements Visitor
{
	private RoadController rc;
	
	public RoadControllerVisitor(RoadController rc)
	{
		this.rc = rc;
	}

	@Override
	public void visit(Car c) {
		// DO NOTHING 
		
	}

	@Override
	public void visit(RoadController rc) {
		// Do Nothing
		
	}

	@Override
	public void visit(Visitor v) {
		v.visit(rc);
	}

}
