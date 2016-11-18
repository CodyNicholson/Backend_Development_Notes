package myproject.model;

public class CarFactory
{
	private static double switchTime = -10;
	
	public static Car createCar(Direction dir, int rIndex)
	{
		Car c = new Car(dir, rIndex);
		System.out.println("Velocity: " + c.getVelocity());
		return c;
	}
	
	public static void updateTimedCarSpawn(double time)
	{
		if(switchTime < 0)
		{
			switchTime = (Math.random() * (ModelParameters.carGenerationDelayMax - ModelParameters.carGenerationDelayMin) + ModelParameters.carGenerationDelayMin);
		}
		if(time > switchTime)
		{
			System.out.println(time+" "+switchTime);
			if(Math.random() > 0.5)
			{
				Model.getModel().addCar(createCar(Direction.horizontal, 0));
				switchTime = time + (Math.random() * (ModelParameters.carGenerationDelayMax - ModelParameters.carGenerationDelayMin) + ModelParameters.carGenerationDelayMin);
			}
			else
			{
				Model.getModel().addCar(createCar(Direction.vertical, 0));
				switchTime = time + (Math.random() * (ModelParameters.carGenerationDelayMax - ModelParameters.carGenerationDelayMin) + ModelParameters.carGenerationDelayMin);
			}
		}
	}
}
