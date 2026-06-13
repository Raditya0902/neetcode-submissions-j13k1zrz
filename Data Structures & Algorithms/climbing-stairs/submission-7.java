class Solution {
    int[] dp;
    public int climbStairs(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp,-1);
        return helper(n);
    }

    int helper(int n){
        if(n == 0) return 1;
        else if(n == 1) return 1;
        else if(dp[n] != -1) return dp[n];
        return dp[n] = helper(n - 1) + helper(n - 2);
    }
}
