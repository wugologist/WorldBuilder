package model;

public class Heightmap implements IHeightmap {
    private int[][] heights;

    public Heightmap(int[][] heights) {
        this.heights = heights;
    }

    public int getMapWidth() {
        return heights.length;
    }

    public int getMapHeight() {
        return heights[0].length;
    }

    @Override
    public int getHeight(int x, int y) {
        return heights[x][y];
    }
}
