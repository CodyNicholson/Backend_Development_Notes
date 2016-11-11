package myproject.model;

public class ModelParameters
{
	public double simTimeStep = 0.1;
	public double simRuntime = 1000.0;
	public int gridRow = 2;
	public int gridColumn = 3;
	public GridPattern p = GridPattern.simple;
	public double carGenerationDelayMin = 2.0;
	public double carGenerationDelayMax = 25.0;
	public double roadLengthMin = 200.0;
	public double roadLengthMax = 500.0;
	public double intersectionMin = 10.0;
	public double intersectionMax = 15.0;
	public double carLenMin = 5.0;
	public double carLenMax = 10.0;
	public double carVelocityMin = 10.0;
	public double carVelocityMax = 30.0;
	public double carStopDistanceMin = 0.5;
	public double carStopDistanceMax = 5.0;
	public double carBrakeDistanceMin = 9.0;
	public double carBrakeDistanceMax = 10.0;
	public double greenLightLenMin = 30.0;
	public double greenLightLenMax = 180.0;
	public double yellowLightLenMin = 4.0;
	public double yellowLightLenMax = 5.0;
}
