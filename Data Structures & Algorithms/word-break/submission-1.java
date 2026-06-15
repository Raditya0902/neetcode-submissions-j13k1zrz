class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        Set<String> dict = new HashSet<>(wordDict);
        dp[n] = true;
        for(int i = s.length() - 1; i >= 0; i--){
            for(int j = i + 1; j <= n; j++){
                if(dict.contains(s.substring(i,j)) && dp[j]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}
