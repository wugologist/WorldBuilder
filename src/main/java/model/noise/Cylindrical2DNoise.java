package model.noise;

public class Cylindrical2DNoise implements I2dNoiseGenerator {

    private final OpenSimplexNoise openSimplexNoise;
    private final double xPeriod;

    public Cylindrical2DNoise(long seed, double xPeriod) {
        this.openSimplexNoise = new OpenSimplexNoise(seed);
        this.xPeriod = xPeriod;
    }

    @Override
    public double eval(double x, double y) {
        // We need cylindrical noise, so that the left and right edges of the map match up.
        // We do this by wrapping the 2d map into a 3d cylinder.
        // The circumference of the cylinder is equal to the period of the pattern, so the edges align when wrapped
        // We then find the 3d noise at the 3d point matching the original 2d coordinate.
        double radius = xPeriod / (2 * Math.PI);
        double theta = (2 * Math.PI * x) / xPeriod; // the angle in radians; proportional to the x distance from edge

        // Cartesian to polar coordinates
        double x2 = radius * Math.cos(theta);
        double y2 = radius * Math.sin(theta);

        // the height of the cylinder is equal to the height of the map, so z2 = y
        return this.openSimplexNoise.eval(x2, y2, y);
    }
}
