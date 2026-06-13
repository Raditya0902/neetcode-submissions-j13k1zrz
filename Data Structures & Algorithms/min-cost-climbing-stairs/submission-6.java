class Solution {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return f(cost, n);
    }
    int f(int[] cost, int lvl){
        if(lvl == 0 || lvl == 1) return 0;
        if(dp[lvl] != -1) return dp[lvl];
        return dp[lvl] = Math.min(cost[lvl - 1] + f(cost, lvl - 1), cost[lvl - 2] + f(cost, lvl - 2));
    }
}
