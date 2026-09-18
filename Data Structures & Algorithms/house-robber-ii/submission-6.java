class Solution {
    int[] dp;
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        dp = new int[n];
        Arrays.fill(dp, -1);
        int[] t1 = new int[n - 1];
        int[] t2 = new int[n - 1];
        for(int i = 0; i < n - 1; i++) t1[i] = nums[i];
        for(int i = 0; i < n - 1; i++) t2[i] = nums[i+1];
        int ans1 = f(t1, n - 1);
        Arrays.fill(dp, -1);
        return Math.max(ans1, f(t2, n - 1));

    }

    int f(int[] nums, int n){
        if(n == 1) return nums[n - 1];
        if(n == 2) return Math.max(nums[n-1], nums[n-2]);
        if(dp[n] != -1) return dp[n];
        return dp[n] = Math.max((nums[n-1] + f(nums, n - 2)), f(nums, n - 1));
    }
}
