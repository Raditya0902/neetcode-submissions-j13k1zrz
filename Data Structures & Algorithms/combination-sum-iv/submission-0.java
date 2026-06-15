class Solution {
    int[] dp;
    public int combinationSum4(int[] nums, int target) {
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        return solve(nums, target);
    }

    int solve(int[] nums, int target){
        if(target == 0) return 1;
        if(target < 0) return 0;
        if(dp[target] != -1) return dp[target];
        int count = 0;
        for(int n: nums){
            count += solve(nums, target - n);
        }
        return dp[target] = count;
    }
}