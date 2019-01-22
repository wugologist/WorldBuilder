package model.settings;

import org.immutables.value.Value;

@Value.Immutable
public interface MapGenerationSettings {
    @Value.Default
    default int scale() {
        return 100;
    }

    @Value.Default
    default int sea_level() {
        return 32;
    }

    @Value.Default
    default int max_height() {
        return 256;
    }
}
