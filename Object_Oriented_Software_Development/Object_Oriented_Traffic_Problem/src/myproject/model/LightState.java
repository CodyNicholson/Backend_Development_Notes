package myproject.model;

import java.awt.Color;

public interface LightState
{
	public void handle(Light context, double time);
	public void setSwitchTime(double time);
	public Color getDrawColor();
	public LightColor getLightColor(Car c);
}
