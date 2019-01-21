import model.IHeightmap;
import model.IHeightmapGenerator;
import model.ImmutableWorldSettings;
import model.RandomHeightmapGenerator;
import view.HeightmapPngViewer;
import view.IHeightmapViewer;

public class WorldBuilder {
    public static void main(String[] args) {
        ImmutableWorldSettings settings = ImmutableWorldSettings.builder()
                .seed(12345)
                .sea_level(10)
                .max_height(256)
                .width(1500)
                .height(1000)
                .build();
        IHeightmapGenerator generator = new RandomHeightmapGenerator(settings);
        IHeightmap map = generator.generate();
        IHeightmapViewer viewer = new HeightmapPngViewer(map);
        viewer.view();
    }
}
