class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for(int n: nums) total += n;
        if(Math.abs(target) > total) return 0;
        if((target + total) %2 != 0) return 0;
        int p = (target + total) / 2;
        int[] dp = new int[p + 1];
        dp[0] = 1;

        for(int num: nums){
            for(int j = p; j >= num; j--){
                dp[j] += dp[j - num];
            }
        }

        return dp[p];
    }
}
