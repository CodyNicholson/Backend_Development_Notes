package myproject.model;

import java.awt.Color;

public class LStateGreenNSRedEW implements LightState
{
	private double duration;
	private double switchTime;
	
	public LStateGreenNSRedEW(double dur)
	{
		this.duration = dur;
	}
	
	@Override
	public void handle(Light context, double time)
	{
		if(time >= switchTime)
		{
			context.setState(context.getLStateYellowNSRedEW(), time);
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
		return Color.RED;
	}

	@Override
	public LightColor getLightColor(Car c) {
		if(c.getDirection() == Direction.horizontal)
		{
			return LightColor.red;
		}
		else
		{
			return LightColor.green;
		}
	}

}
