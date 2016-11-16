package myproject.model;

public class Sink extends Road implements CarAccepter
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
