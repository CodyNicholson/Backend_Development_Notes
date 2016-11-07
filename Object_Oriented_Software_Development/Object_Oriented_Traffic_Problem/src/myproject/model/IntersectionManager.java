package myproject.model;

public class IntersectionManager
{
	
	private LightState state;
	private Light[][] lights;
	private LStateGreenNSRedEW NSgreenEWred;
	private LStateYellowNSRedEW NSyellowEWred;
	private LStateRedNSGreenEW NSredEWgreen;
	private LStateRedNSYellowEW NSredEWyellow;
	
	public IntersectionManager(Light[][] lights)
	{
		this.lights = lights;
		this.NSgreenEWred = new LStateGreenNSRedEW(40);
		this.NSyellowEWred = new LStateYellowNSRedEW(25);
		this.NSredEWgreen = new LStateRedNSGreenEW(40);
		this.NSredEWyellow = new LStateRedNSYellowEW(25);
		this.state = this.NSgreenEWred;
	}
	
	public void setState(LightState s, double time)
	{
		this.state = s;
		this.state.setSwitchTime(time);
		for(int i = 0; i < lights.length; i++)
		{
			for(int j = 0; j < lights[i].length; j++)
			{
				lights[i][j].setColor(this.state.getColor(), time, lights[i][j]);
			}
		}
	}
	
	public void update(double time)
	{
		state.handle(this, time);
	}
	
	public LStateGreenNSRedEW getLStateGreenNSRedEW()
	{
		return NSgreenEWred;
	}
	
	public LStateYellowNSRedEW getLStateYellowNSRedEW()
	{
		return NSyellowEWred;
	}
	
	public LStateRedNSGreenEW getLStateRedNSGreenEW()
	{
		return NSredEWgreen;
	}
	
	public LStateRedNSYellowEW getLStateRedNSYellowEW()
	{
		return NSredEWyellow;
	}
	
}
