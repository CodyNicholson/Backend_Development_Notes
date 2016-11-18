package myproject.model;

import java.awt.Color;

public class LStateYellowNSRedEW implements LightState
{
	private double duration;
	private double switchTime;
	
	public LStateYellowNSRedEW(double dur)
	{
		this.duration = dur;
	}
	
	@Override
	public void handle(Light context, double time)
	{
		if(time >= switchTime)
		{
			context.setState(context.getLStateRedNSGreenEW(), time);
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
		return Color.blue;
	}
	
	@Override
	public LightColor getLightColor(Car c) {
		if(c.getDirection() == Direction.horizontal)
		{
			return LightColor.red;
		}
		else
		{
			return LightColor.yellow;
		}
	}
}
