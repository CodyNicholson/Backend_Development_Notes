package myproject.model;

public interface Visitor
{
	public void visit(Car c);
	public void visit(RoadController rc);
	public void visit(Visitor v);
}
