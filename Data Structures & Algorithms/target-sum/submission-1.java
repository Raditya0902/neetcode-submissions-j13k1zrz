class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for(int n: nums) total += n;
        if(Math.abs(target) > total) return 0;
        if((target + total) % 2 != 0) return 0;

        int half = (target + total) / 2;
        int[] dp = new int[half + 1];
        dp[0] = 1;

        for(int num: nums){
            for(int j = half; j >= num; j--){
                dp[j] = dp[j] + dp[j-num];
            }
        }
        return dp[half];
    }
}
