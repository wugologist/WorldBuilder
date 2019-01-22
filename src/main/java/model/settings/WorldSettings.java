package model.settings;

import org.immutables.value.Value;

@Value.Immutable
public interface WorldSettings {
    long seed();
    int height();
    int width();

    @Value.Default
    default ImmutableMapGenerationSettings mapGenerationSettings() {
        return ImmutableMapGenerationSettings.builder().build();
    };
}
