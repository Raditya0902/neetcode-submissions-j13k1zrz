class Solution {
    int memo[];
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        memo = new int[n];
        Arrays.fill(memo, -1);
        int max = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(max, dfs(i, nums));
        }
        return max;
    }

    int dfs(int i, int[] nums){
        if(memo[i] != -1) return memo[i];
        int maxLen = 1;
        for(int j = i + 1; j < nums.length; j++){
            if(nums[j] > nums[i]){
                maxLen = Math.max(maxLen, 1 + dfs(j, nums));
            }
        }
        return memo[i] = maxLen;
    }
}
