package model;

public class Heightmap implements IHeightmap {
    private int[][] heights;

    public Heightmap(int[][] heights) {
        this.heights = heights;
    }

    public int get_width() {
        return heights.length;
    }

    public int get_height() {
        return heights[0].length;
    }

    @Override
    public int get_value(int x, int y) {
        return heights[x][y];
    }
}
