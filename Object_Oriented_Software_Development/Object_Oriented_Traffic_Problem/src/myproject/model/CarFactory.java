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
			switchTime = (Math.random() * (MP.carGenerationDelayMax - MP.carGenerationDelayMin) + MP.carGenerationDelayMin);
		}
		if(time > switchTime)
		{
			System.out.println(time+" "+switchTime);
			if(Math.random() > 0.5)
			{
				Model.getModel().addCar(createCar(Direction.horizontal, 0));
				switchTime = time + (Math.random() * (MP.carGenerationDelayMax - MP.carGenerationDelayMin) + MP.carGenerationDelayMin);
			}
			else
			{
				Model.getModel().addCar(createCar(Direction.vertical, 0));
				switchTime = time + (Math.random() * (MP.carGenerationDelayMax - MP.carGenerationDelayMin) + MP.carGenerationDelayMin);
			}
		}
	}
}
