package model;

import model.noise.I2dNoiseGenerator;
import model.noise.Tilable2DSimplexNoise;
import model.settings.ImmutableWorldSettings;

public class RandomHeightmapGenerator implements IHeightmapGenerator {
    private final ImmutableWorldSettings worldSettings;
    private final I2dNoiseGenerator noiseGenerator;

    public RandomHeightmapGenerator(ImmutableWorldSettings worldSettings) {
        this.worldSettings = worldSettings;
//        this.noiseGenerator = new OpenSimplexNoiseTileable3D(
//                worldSettings.seed(),
//                worldSettings.xWrapping() ? worldSettings.width() / 6 : worldSettings.width(),
//                100, 100, 1);
//        this.noiseGenerator = new OpenSimplexNoise(worldSettings.seed());
        this.noiseGenerator = new Tilable2DSimplexNoise(worldSettings.seed(), worldSettings.width(), worldSettings.height());
    }

    public IHeightmap generate() {
        // based on https://cmaher.github.io/posts/working-with-simplex-noise/
        int[][] heights = new int[worldSettings.width()][worldSettings.height()];
        for (int x = 0; x < worldSettings.width(); x++) {
            for (int y = 0; y < worldSettings.height(); y++) {
                heights[x][y] = heightAtPoint(x, y);
            }
        }
        return new Heightmap(heights);
    }

    private int heightAtPoint(int x, int y) {
        double maxAmplitude = 0;
        double amplitude = 1;
        double frequency = 1.0 / worldSettings.mapGenerationSettings().scale();
        double noise = 0;

        for (int i=0; i<16; i++) {
            noise += noiseGenerator.eval(x * frequency, y * frequency) * amplitude;
            maxAmplitude += amplitude;
            amplitude *= 0.5;
            frequency *= 2;
        }
        noise /= maxAmplitude;
        return (int) ((noise + 1) / 2 * worldSettings.mapGenerationSettings().max_height());
    }
}
