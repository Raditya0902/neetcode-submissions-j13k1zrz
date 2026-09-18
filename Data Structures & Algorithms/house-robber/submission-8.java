class Solution {
    int[] dp;
    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return f(nums, n);
    }

    int f(int[] nums, int n){
        if(n == 1) return nums[n - 1];
        if(n == 2) return Math.max(nums[n-1], nums[n-2]);
        if(dp[n] != -1) return dp[n];
        return dp[n] = Math.max((nums[n-1] + f(nums, n - 2)), f(nums, n - 1));
    }
}
