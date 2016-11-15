package myproject.model;

public class IntersectionManager
{
	private Light[][] lights;
	
	public IntersectionManager(Light[][] lights)
	{
		this.lights = lights;
	}
	
	public void update(double time)
	{
		for(int i = 0; i < lights.length; i++)
		{
			for(int j = 0; j < lights[i].length; j++)
			{
				lights[i][j].update(time);
			}
		}
	}	
}
