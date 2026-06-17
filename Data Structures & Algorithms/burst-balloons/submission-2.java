class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] balls = new int[n+2];
        balls[0] = 1;
        balls[n+1] = 1;
        for(int i = 0; i < n; i++) balls[i+1] = nums[i];

        int size = n + 2;
        int[][] dp = new int[size][size];

        for(int len = 2; len < size; len++){
            for(int left = 0; left < size - len; left++){
                int right = left + len;
                for(int k = left + 1; k < right; k++){
                    dp[left][right] = Math.max(dp[left][right], balls[left] * balls[k] * balls[right] + dp[left][k] + dp[k][right]);
                }
            }
        }

        return dp[0][n+1];
    }
}
