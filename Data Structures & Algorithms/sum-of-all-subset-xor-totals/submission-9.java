class Solution {
    public int subsetXORSum(int[] nums) {
        int sum[] = {0};
        dfs(0, nums, 0, sum);
        return sum[0];
    }

    void dfs(int idx, int[] nums, int xor, int[] sum){
        sum[0] += xor;
        for(int i = idx; i < nums.length; i++){
            xor ^= nums[i];
            dfs(i+1, nums, xor, sum);
            xor ^= nums[i];
        }
    }
}