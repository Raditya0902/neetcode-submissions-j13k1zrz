class Solution {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int n = nums.length, sum = 0;
        for(int x: nums) sum += x;
        if(sum % 2 != 0) return false;
        int target = sum / 2;
        dp = new Boolean[n + 1][target + 1];
        return solve(nums, n, target);
    }

    boolean solve(int[] nums, int i, int target){
        if(target == 0) return true;
        if(i == 0 || target < 0) return false;
        if(dp[i][target] != null) return dp[i][target];
        return dp[i][target] = solve(nums, i - 1, target - nums[i-1]) || solve(nums, i-1, target);
    }
}
