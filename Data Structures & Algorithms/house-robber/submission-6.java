class Solution {
    int[] dp;
    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return f(nums, n);
    }

    int f(int[] nums, int hs){
        if(hs == 1) return nums[hs-1];
        if(hs == 2) return Math.max(nums[hs-1], nums[hs-2]);
        if(dp[hs] != -1) return dp[hs];
        int pick = nums[hs-1] + f(nums, hs - 2);
        int notPick = f(nums, hs - 1);
        return dp[hs] = Math.max(pick, notPick);
    }
}
