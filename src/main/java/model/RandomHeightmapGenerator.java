package model;

import model.noise.OpenSimplexNoise;

public class RandomHeightmapGenerator implements IHeightmapGenerator {
    private final ImmutableWorldSettings worldSettings;

    public RandomHeightmapGenerator(ImmutableWorldSettings worldSettings) {
        this.worldSettings = worldSettings;
    }

    public IHeightmap generate() {
        int[][] heights = new int[worldSettings.width()][worldSettings.height()];
        OpenSimplexNoise noise = new OpenSimplexNoise(worldSettings.seed());
        for (int x=0; x<worldSettings.width(); x++) {
            for (int y=0; y<worldSettings.height(); y++) {
                double noise_value = noise.eval(x, y); // in [-1. 1]
                int normalized = (int)((noise_value + 1) / 2 * worldSettings.max_height());
                heights[x][y] = normalized;
            }
        }
        return new Heightmap(heights);
    }
}
