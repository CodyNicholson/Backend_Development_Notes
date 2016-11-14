package myproject.model;

/**
 * Static class for model parameters.
 */
public class MP {
	private MP() {}
	/** Length of cars, in meters 10.0 */
	public static double carLength = (Math.random() * (ModelParameters.carLenMin - ModelParameters.carLenMax) + ModelParameters.carLenMin);
	/** Length of roads, in meters 200.0 */
	public static double roadLength = (Math.random() * (ModelParameters.roadLengthMin - ModelParameters.roadLengthMax) + ModelParameters.roadLengthMin);
	/** Maximum car velocity, in meters/second 6.0 */
	public static double maxVelocity = (Math.random() * (ModelParameters.carVelocityMin - ModelParameters.carVelocityMax) + ModelParameters.carVelocityMin);
}

