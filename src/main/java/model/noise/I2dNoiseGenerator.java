package model.noise;

public interface I2dNoiseGenerator {
    double eval(double x, double y); // Generate coherent noise at this point in the range [-1, 1]
}
