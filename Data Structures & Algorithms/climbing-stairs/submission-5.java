class Solution {
    int[] dp;
    public int climbStairs(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        helper(n);
        return dp[n];
    }

    int helper(int n){
        if(n <= 1) return dp[n] = 1;
        if(dp[n] != -1) return dp[n];
        return dp[n] = helper(n-1) + helper(n-2);
    }
}
