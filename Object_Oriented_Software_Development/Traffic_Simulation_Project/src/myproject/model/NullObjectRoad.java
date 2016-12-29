package myproject.model;

public class NullObjectRoad extends Road implements CarAccepter
{
	@Override
	public void accept(Car d)
	{
		Model.getModel().removeAgent(d);
	}
	
	@Override
	public void remove(Car d)
	{
		// Do nothing
	}
}
