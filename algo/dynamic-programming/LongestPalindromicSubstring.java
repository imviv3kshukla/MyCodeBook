import java.util.Arrays;

class LongestPalindromicSubstring {


    public String longestPalindrome(String input) {
        String output = "";
        int start = 0;
        int end = 0;
        boolean dp[][] = new boolean[input.length()][input.length()];
        for(boolean [] row : dp) Arrays.fill(row, false);
    
        for(int i=0;i<input.length();i++) {
            dp[i][i] = true;
            if(i < input.length() -1 && input.charAt(i) == input.charAt(i+1)) {
                dp[i][i+1] = true;
                start = i;
                end = i+1;
            }
        }

        for(int k=3; k <= input.length();k++) {
            for(int i=0; i + k <= input.length();i++) {
                int j = i+k-1;
                if(input.charAt(i) == input.charAt(j) && dp[i+1][j-1]) {
                    dp[i][j] = true;
                    start = i;
                    end = j;
                }
            }
        }
        output = input.substring(start, end+1);
        return output;
    }

    public static void main(String args[]) {
        
    }

}