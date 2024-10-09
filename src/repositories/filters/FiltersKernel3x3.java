package repositories.filters;

public class FiltersKernel3x3 {
    public int[][] nitidez = {
            {0, -1, 0},
            {-1, 5, -1},
            {0, -1, 0}
    };

    public double[][] gaussiano = {
            {0.0625, 0.125, 0.0625},
            {0.125, 0.25, 0.125},
            {0.0625, 0.125, 0.0625}
    };

    public int[][] realceBorda1 = {
            { 1, 1, 1 },
            { 0, 0, 0 },
            { -1, -1, -1 }
    };

    public int[][] realceBorda2 = {
            { -2, -1, 0 },
            { -1, 1, 1 },
            { 0, 1, 2 }
    };

    public int[][] realceBorda3 = {
            { -1, -1, -1 },
            { -1, 8, -1 },
            { -1, -1, -1 }
    };
}
