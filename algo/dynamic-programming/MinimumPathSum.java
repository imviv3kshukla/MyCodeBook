



class MinimumPathSum {

    public int minimumPathSum(int [][] grid) {
        int R = grid.length;
        int C = grid[0].length;

        for(int i = 0; i < R; i++) {
            for(int j=0; j<C; j++) {
                if(i > 0 && j > 0) grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
                if(i == 0 && j == 0) continue;
                if (j == 0) grid[i][j] += grid[i-1][j];
                if (i == 0) grid[i][j] += grid[i][j-1];
            }
        }
        return grid[R-1][C-1];
    }

    public static void main(String args[]) {

    }
}