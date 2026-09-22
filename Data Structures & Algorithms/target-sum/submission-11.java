class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num: nums) sum += num;
        if((Math.abs(target) > sum) || (target + sum) % 2 != 0) return 0;
        int p = (target + sum) / 2;
        
        int[] dp = new int[p + 1];
        dp[0] = 1;

        for(int num: nums){
            for(int j = p; j >= num; j--){
                dp[j] = dp[j] + dp[j-num];
            }
        }

        return dp[p];
    }
}
