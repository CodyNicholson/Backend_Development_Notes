package myproject.model;

public class ModelParameters
{
	public double simTimeStep = 0.01;
	public double simRuntime = 1000.0;
	public static int gridRow = 2;
	public static int gridColumn = 3;
	public static GridPattern p = GridPattern.alternating;
	public static double carGenerationDelayMin = 10.0;
	public static double carGenerationDelayMax = 25.0;
	public static double roadLengthMin = 250.0;
	public static double roadLengthMax = 280.0;
	public static double intersectionMin = 10.0;
	public static double intersectionMax = 15.0;
	public static double carLenMin = 10.0; // Changing Car Length creates bug where cars travel both directions on same road
	public static double carLenMax = 10.0; // Changing Car Length creates bug where cars travel both directions on same road
	public static double carVelocityMin = 10.0;
	public static double carVelocityMax = 15.0;
	public static double carStopDistanceMin = 10.0;
	public static double carStopDistanceMax = 20.0;
	public static double carBrakeDistanceMin = 9.0;
	public static double carBrakeDistanceMax = 10.0;
	public static double greenLightLenMin = 120.0;
	public static double greenLightLenMax = 200.0;
	public static double yellowLightLenMin = 35.0;
	public static double yellowLightLenMax = 50.0;
}
