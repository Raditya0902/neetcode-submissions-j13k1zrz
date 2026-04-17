class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if(m + n != s3.length()) return false;
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(i == 0 && j == 0) continue;
                int k = i + j - 1;
                boolean fromS1 = false, fromS2 = false;
                if(i > 0 && s1.charAt(i-1) == s3.charAt(k)){
                    fromS1 = dp[i-1][j];
                }
                if(j > 0 && s2.charAt(j- 1) == s3.charAt(k)){
                    fromS2 = dp[i][j-1];
                }
                dp[i][j] = fromS1 || fromS2;
            }
        }
        return dp[m][n];
    }
}
