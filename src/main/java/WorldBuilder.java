import model.IHeightmap;
import model.IHeightmapGenerator;
import model.ImmutableWorldSettings;
import model.RandomHeightmapGenerator;

public class WorldBuilder {
    public static void main(String[] args) {
        ImmutableWorldSettings settings = ImmutableWorldSettings.builder()
                .seed(12345)
                .sea_level(10)
                .max_height(256)
                .width(10)
                .height(10)
                .build();
        IHeightmapGenerator generator = new RandomHeightmapGenerator(settings);
        IHeightmap map = generator.generate();
    }
}
