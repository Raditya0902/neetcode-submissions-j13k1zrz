class Solution {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return f(cost, n);
    }

    int f(int[] cost, int n){
        if(n == 0 || n == 1) return 0;
        if(dp[n] != -1) return dp[n];
        return dp[n] = Math.min(cost[n-1] + f(cost, n - 1), cost[n-2] + f(cost, n - 2));
    }
}
