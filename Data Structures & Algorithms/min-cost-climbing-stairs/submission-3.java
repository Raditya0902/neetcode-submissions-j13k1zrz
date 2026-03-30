class Solution {
    int[]t = new int[102];
    public int minCostClimbingStairs(int[] cost) {
        Arrays.fill(t, -1);
        return Math.min(helper(0, cost), helper(1, cost));
    }

    int helper(int i, int[] cost){
        if(i >= cost.length){
            return 0;
        }
        if(t[i] != -1) return t[i];
        return t[i] = cost[i] + Math.min(helper(i + 2, cost),helper(i + 1, cost));
    }
}
