package myproject.model;

import java.awt.Color;

public class LStateRedNSGreenEW implements LightState
{
	private double duration;
	private double switchTime;
	
	public LStateRedNSGreenEW(double dur)
	{
		this.duration = dur;
	}
	
	@Override
	public void handle(Light context, double time)
	{
		if(time >= switchTime)
		{
			context.setState(context.getLStateRedNSYellowEW(), time);
		}
	}

	@Override
	public void setSwitchTime(double time)
	{
		switchTime = time + duration;
	}

	@Override
	public Color getDrawColor()
	{
		return Color.GREEN;
	}
	
	@Override
	public LightColor getLightColor(Car c) {
		if(c.getDirection() == Direction.horizontal)
		{
			return LightColor.green;
		}
		else
		{
			return LightColor.red;
		}
	}
}
