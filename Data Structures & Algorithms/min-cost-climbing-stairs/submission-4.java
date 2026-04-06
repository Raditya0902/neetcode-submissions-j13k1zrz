class Solution {
    int[] t;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        t = new int[n + 1];
        Arrays.fill(t, -1);
        return f(n, cost);
    }

    int f(int i, int[] cost){
        if(i == 0 || i == 1) return 0; 
        if(t[i] != -1) return t[i];
        return t[i] = Math.min(cost[i-1] + f(i-1, cost), cost[i-2] + f(i-2, cost));
    }
}
