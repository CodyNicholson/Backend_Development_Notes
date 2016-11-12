package myproject.model;

/**
 * Static class for model parameters.
 */
public class MP {
	private MP() {}
	/** Length of cars, in meters */
	public static double carLength = (int) (Math.random() * (ModelParameters.carLenMin - ModelParameters.carLenMax) + ModelParameters.carLenMin);
	/** Length of roads, in meters */
	public static double roadLength = (int) (Math.random() * (ModelParameters.roadLengthMin - ModelParameters.roadLengthMax) + ModelParameters.roadLengthMin);
	/** Maximum car velocity, in meters/second */
	public static double maxVelocity = (int) (Math.random() * (ModelParameters.carVelocityMin - ModelParameters.carVelocityMax) + ModelParameters.carVelocityMin);
}

