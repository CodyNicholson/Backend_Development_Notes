package myproject.main;

import myproject.model.Car;

public class TEST
{
	private static double time;
	
	public static void main(String[] args)
	{
		{
			Car testCar = new Car(null, 0);
			testCar.run(time);
		}
		System.exit(0);
	}
}
