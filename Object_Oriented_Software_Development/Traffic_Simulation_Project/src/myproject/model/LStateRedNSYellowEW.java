package myproject.model;

import java.awt.Color;

public class LStateRedNSYellowEW implements LightState
{
	private double duration;
	private double switchTime;
	
	public LStateRedNSYellowEW(double dur)
	{
		this.duration = dur;
	}
	
	@Override
	public void handle(Light context, double time)
	{
		if(time >= switchTime)
		{
			context.setState(context.getLStateGreenNSRedEW(), time);
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
		return Color.YELLOW;
	}
	
	@Override
	public LightColor getLightColor(Car c) {
		if(c.getDirection() == Direction.horizontal)
		{
			return LightColor.yellow;
		}
		else
		{
			return LightColor.red;
		}
	}
}
