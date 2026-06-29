class Solution {
    int[] sum = {0};
    public int subsetXORSum(int[] nums) {
        dfs(0, nums, 0);
        return sum[0];
    }

    void dfs(int idx, int[] nums, int xor){
        for(int i = idx; i < nums.length; i++){
            xor ^= nums[i];
            dfs(i+1, nums, xor);
            xor ^= nums[i];
        }
        sum[0] += xor;
    }
}