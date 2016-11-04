package myproject.model;

import java.awt.Color;

public interface LightState
{
	public void handle(IntersectionManager context, double time);
	public void setSwitchTime(double time);
	public Color getColor();
}
