package view;

import com.google.common.collect.ImmutableMap;
import model.Climate;
import model.IWorldMap;
import model.settings.ImmutableWorldSettings;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import static model.Climate.*;

public class WorldMapViewer implements IMapViewer {
    private static final Map<Climate, Integer> CLIMATE_HUES = ImmutableMap.of(
            OCEAN, 196,
            GRASSLAND, 125,
            SNOW, 130
    );

    private final IWorldMap map;
    private final ImmutableWorldSettings settings;

    public WorldMapViewer(IWorldMap map, ImmutableWorldSettings settings) {
        this.map = map;
        this.settings = settings;
    }

    @Override
    public void view() {
        int mapWidth = map.getMapWidth();
        int mapHeight = map.getMapHeight();
        BufferedImage image = new BufferedImage(mapWidth, mapHeight, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWidth; x++) {
                Climate climate = map.getClimate(x, y);
                int height = map.getHeight(x, y);
                int rgb = Color.HSBtoRGB(
                        CLIMATE_HUES.get(climate) / 360f,
                        1,
                        (float) height / settings.mapGenerationSettings().max_height());
//                int rgb = 0x010101 * (map.getClimate(x, y).equals(OCEAN) ? 0 : height);
                image.setRGB(x, y, rgb);
            }
        }
        try {
            ImageIO.write(image, "png", new File("world.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
