import java.util.Arrays;

class UniquePathsII {


    public int uniquePathsWithObstacles(int [][] obstaclesGrid) {
        int n = obstaclesGrid.length;
        int m = obstaclesGrid[0].length;
        int dp[][] = new int[n][m];
        for(int [] row : dp) Arrays.fill(row, 0);
        for(int i=0; i < n;i++) {
            for(int j=0;j<m;j++) {
                if(obstaclesGrid[i][j] == 1) continue;
                if(i == 0 && j == 0) dp[i][j] = 1; 
                else if(i == 0 || j == 0)  {
                    if (j > 0 && obstaclesGrid[i][j-1] != 1) 
                        dp[i][j] = dp[i][j-1];
                    if (i > 0 && obstaclesGrid[i-1][j] != 1) 
                        dp[i][j] = dp[i-1][j];
                }
                else {
                    if(obstaclesGrid[i][j-1] == 0) dp[i][j] += dp[i][j-1];
                    if(obstaclesGrid[i-1][j] == 0) dp[i][j] += dp[i-1][j];
                }
            }
        }
        return dp[n-1][m-1];
    }

    public static void main(String args[]) {

    }
}