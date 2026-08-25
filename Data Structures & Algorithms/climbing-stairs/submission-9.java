class Solution {
    int[] dp;

    public int climbStairs(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        f(n);
        return dp[n];
    }

    int f(int n){
        if(n == 0 || n == 1) return dp[n] = 1;
        if(dp[n] != -1) return dp[n];
        return dp[n] = f(n - 1) + f(n - 2);
    }
}
