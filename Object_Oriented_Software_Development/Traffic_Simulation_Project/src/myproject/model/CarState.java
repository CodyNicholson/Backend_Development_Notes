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
