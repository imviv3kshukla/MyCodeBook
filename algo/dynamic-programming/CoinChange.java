import java.util.Arrays;

class CoinChange {

    public int coinChange(int [] coins, int amount) {
        int [] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for(int i : coins) if(amount >= i) dp[i] = 1;
        for(int i=0; i <= amount;i++) {
            for (int j : coins)
                if(i >= j && dp[i-j] != -1) {
                    if (dp[i] == -1) dp[i] = dp[i - j] + 1; 
                    else dp[i] = Math.min(dp[i - j] + 1, dp[i]);
                }
        }
        return dp[amount];
    }

    public static void main(String args[]) {
        CoinChange solution = new CoinChange();
        
    }
}