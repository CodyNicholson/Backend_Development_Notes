package myproject.model;

/*
 * How any object talks to roadController
 * To keep the car reference so that the road controller can move it
 */
public interface Command
{
	public void invoke();
}
