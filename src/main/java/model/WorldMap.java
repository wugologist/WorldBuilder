package model;

import model.settings.ImmutableWorldSettings;

public class WorldMap implements IWorldMap {
    private final IHeightmap heightmap;
    private final ImmutableWorldSettings settings;

    public WorldMap(ImmutableWorldSettings settings) {
        this(new RandomHeightmapGenerator(settings).generate(), settings);
    }

    public WorldMap(IHeightmap heightmap, ImmutableWorldSettings settings) {
        this.heightmap = heightmap;
        this.settings = settings;
    }

    @Override
    public int getMapWidth() {
        return heightmap.getMapWidth();
    }

    @Override
    public int getMapHeight() {
        return heightmap.getMapHeight();
    }

    @Override
    public int getHeight(int x, int y) {
        return heightmap.getHeight(x, y);
    }

    @Override
    public Climate getClimate(int x, int y) {
        if (getHeight(x, y) < settings.mapGenerationSettings().sea_level()) {
            return Climate.OCEAN;
        } else {
            return Climate.GRASSLAND;
        }
    }
}
