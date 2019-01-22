package model;

public interface IHeightmap {
    int getMapWidth();

    int getMapHeight();

    int getHeight(int x, int y);
}
