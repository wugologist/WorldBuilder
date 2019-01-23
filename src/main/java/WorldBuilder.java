import model.*;
import model.settings.ImmutableWorldSettings;
import view.HeightmapPngViewer;
import view.IMapViewer;
import view.WorldMapViewer;

public class WorldBuilder {
    public static void main(String[] args) {
        ImmutableWorldSettings settings = ImmutableWorldSettings.builder()
                .seed(12345)
                .width(1500)
                .height(1000)
                .xWrapping(true)
                .build();
        IHeightmapGenerator generator = new RandomHeightmapGenerator(settings);
        IHeightmap heightmap = generator.generate();
        IMapViewer viewer = new HeightmapPngViewer(heightmap);
        viewer.view();

        IWorldMap map = new WorldMap(heightmap, settings);
        IMapViewer worldMapViewer = new WorldMapViewer(map, settings);
        worldMapViewer.view();
    }
}
