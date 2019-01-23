package model.noise;

public class Tilable2DSimplexNoise implements I2dNoiseGenerator {

    private final OpenSimplexNoise openSimplexNoise;
    private final int xPeriod;
    private final int yPeriod;

    public Tilable2DSimplexNoise(long seed, int xPeriod, int yPeriod) {
        this.openSimplexNoise = new OpenSimplexNoise(seed);
        this.xPeriod = xPeriod;
        this.yPeriod = yPeriod;
    }

    @Override
    public double eval(double x, double y) {
        double s = x / this.xPeriod;
        double t = y / this.yPeriod;

        double nx = -1 + Math.cos(s * 2 * Math.PI) * 2 / (2 * Math.PI);
        double ny = -1 +  Math.sin(s * 2 * Math.PI) * 2 / (2 * Math.PI);

        return this.openSimplexNoise.eval(nx, ny, t);
    }
}
