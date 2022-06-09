
import java.util.HashSet;
import java.util.Set;

class DecodeWays {
    public int numDecodings(String s) {
        Set<String> charset = new HashSet<>();
        for(int i=1;i<=26;i++) charset.add(String.valueOf(i));
        int dp[] = new int[s.length()+1];
        dp[0] = 1;
        for(int i = 1;i <= s.length();i++) {
            String lastOne = "" + s.charAt(i-1);
            if(charset.contains(lastOne)) dp[i] += dp[i-1];
            if(i == 1) continue;
            String lastTwo = "" + s.charAt(i-2) + s.charAt(i-1);
            if(charset.contains(lastTwo)) dp[i] += dp[i-2];
        }
        return dp[s.length()];
    }

    public static void main(String args[] ) {
        DecodeWays solution = new DecodeWays();
        solution.numDecodings("10101");
    }
}