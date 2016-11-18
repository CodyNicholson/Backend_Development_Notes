package myproject.model;

public class CarState
{
	private Car nextCar;
	private Light nextLight;
	
	public CarState(Car nextCar, Light nextLight)
	{
		this.setNextCar(nextCar);
		this.setNextLight(nextLight);
	}
	
	public void run(Car c)
	{
		if(nextCar != null && c.getRoadIndex() == nextCar.getRoadIndex())
		{
			if(nextCar.getPosition()-(c.getPosition()+c.getVelocity()+MP.carLength) < c.getStopDistance())
				c.speed = 0; 
			else
				c.speed = 1;
		}
		else if(nextLight != null && nextLight.getLightColor(c) == LightColor.red)
		{
			//System.out.println(c.getVelocity()+"V  "+(c.getPosition()+c.getVelocity())+" "+(MP.roadLength - c.getStopDistance()));
			if(c.getPosition()+c.getVelocity()+MP.carLength >= (MP.roadLength-c.getStopDistance()))
				c.speed = 0;
			else
				c.speed = 1;
		}
		else
			c.speed = 1;
	}

	public Light getNextLight() {
		return nextLight;
	}

	public void setNextLight(Light nextLight) {
		this.nextLight = nextLight;
	}

	public Car getNextCar() {
		return nextCar;
	}

	public void setNextCar(Car nextCar) {
		this.nextCar = nextCar;
	}

}
