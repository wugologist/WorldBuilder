package view;

import model.IHeightmap;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HeightmapPngViewer implements IMapViewer {
    private IHeightmap map;

    public HeightmapPngViewer(IHeightmap map) {
        this.map = map;
    }

    @Override
    public void view() {
        int width = map.getMapWidth();
        int height = map.getMapHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = 0x010101 * map.getHeight(x, y);
                image.setRGB(x, y, rgb);
            }
        }
        try {
            ImageIO.write(image, "png", new File("noise.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
