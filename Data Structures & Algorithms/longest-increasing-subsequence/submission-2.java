class Solution {
    int[][] memo;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        memo = new int[n][n+1];
        return solve(nums, 0, -1); 
    }

    int solve(int[] nums, int i, int prev){
        if(i == nums.length) return 0;
        if(memo[i][prev+1] != 0) return memo[i][prev + 1];
        int skip = solve(nums, i + 1, prev);
        int take = 0;
        if(prev == -1 || nums[i] > nums[prev]) take = 1 + solve(nums, i + 1, i);
        return memo[i][prev + 1] = Math.max(skip, take);
    }
}
