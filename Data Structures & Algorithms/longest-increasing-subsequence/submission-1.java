class Solution {
    Integer memo[][];
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        memo = new Integer[n][n+1];
        return dfs(0, -1, nums);
    }

    int dfs(int ind, int prev, int[] nums){
        if(ind == nums.length) return 0;
        if(memo[ind][prev + 1] != null) return memo[ind][prev + 1];
        int notTake = dfs(ind + 1, prev, nums);
        int take = 0;
        if(prev == -1 || nums[ind] > nums[prev]){
            take = 1 + dfs(ind+1, ind, nums);
        }
        return memo[ind][prev+1] = Math.max(take, notTake);
    }
}
