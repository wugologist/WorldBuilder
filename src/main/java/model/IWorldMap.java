package model;

public interface IWorldMap extends IHeightmap {
    Climate getClimate(int x, int y);
}
