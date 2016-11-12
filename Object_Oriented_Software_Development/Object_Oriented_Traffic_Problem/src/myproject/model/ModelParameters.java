package myproject.model;

public class ModelParameters
{
	public double simTimeStep = 0.1;
	public double simRuntime = 1000.0;
	public int gridRow = 2;
	public int gridColumn = 3;
	public GridPattern p = GridPattern.simple;
	public static double carGenerationDelayMin = 2.0;
	public static double carGenerationDelayMax = 25.0;
	public static double roadLengthMin = 250.0;
	public static double roadLengthMax = 280.0;
	public static double intersectionMin = 10.0;
	public static double intersectionMax = 15.0;
	public static double carLenMin = 10.0; // Changing Car Length creates bug where cars travel both directions on same road
	public static double carLenMax = 10.0; // Changing Car Length creates bug where cars travel both directions on same road
	public static double carVelocityMin = 10.0;
	public static double carVelocityMax = 20.0;
	public static double carStopDistanceMin = 0.5;
	public static double carStopDistanceMax = 5.0;
	public static double carBrakeDistanceMin = 9.0;
	public static double carBrakeDistanceMax = 10.0;
	public static double greenLightLenMin = 30.0;
	public static double greenLightLenMax = 180.0;
	public static double yellowLightLenMin = 4.0;
	public static double yellowLightLenMax = 5.0;
}
