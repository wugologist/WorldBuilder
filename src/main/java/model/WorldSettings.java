package model;

import org.immutables.value.Value;

@Value.Immutable
public interface WorldSettings {
    long seed();
    int height();
    int width();
    int max_height();
    int sea_level();
}
