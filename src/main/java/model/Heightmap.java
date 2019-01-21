package model;

public class Heightmap implements IHeightmap {
    private int[][] heights;

    public Heightmap(int[][] heights) {
        this.heights = heights;
    }

    public int get_width() {
        return heights[0].length;
    }

    public int get_height() {
        return heights.length;
    }

    @Override
    public int get_value(int x, int y) {
        return heights[x][y];
    }
}
