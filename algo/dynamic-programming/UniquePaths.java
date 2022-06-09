
import java.util.Arrays;
public class UniquePaths {
    
    public int uniquePaths(int n, int m) {
        int dp[][] = new int[n+1][m+1];
        for(int[] row : dp) Arrays.fill(row, 0);
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                if(i == 1 || j == 1) dp[i][j] = 1;
                else dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[n][m];
    }

    // space optimized
    public int uniquePathsSpaceOptimized(int n, int m) {
        int dp[] = new int[m];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        for(int i=0;i<n;i++) {
            for(int j=1;j<m;j++) {
                dp[j] += dp[j-1];
            }
        }
        return dp[m-1];
    }

    public static void main(String args[]) {

    }
}