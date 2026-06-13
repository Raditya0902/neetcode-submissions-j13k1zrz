class Solution {
    int[] dp;
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] t = new int[n-1];
        dp = new int[n];
        Arrays.fill(dp, - 1);
        for(int i = 0; i < n - 1; i++){
            t[i] = nums[i];
        }
        int ans1 = f(t, n - 1);

        Arrays.fill(dp, - 1);
        for(int i = 1; i < n; i++){
            t[i-1] = nums[i];
        }
        int ans2 = f(t, n - 1);
        return Math.max(ans1, ans2);
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
