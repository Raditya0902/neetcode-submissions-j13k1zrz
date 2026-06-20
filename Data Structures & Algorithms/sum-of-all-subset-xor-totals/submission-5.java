class Solution {
    public int subsetXORSum(int[] nums) {
        int[] state = new int[]{0,0};
        dfs(nums, 0, state);
        return state[1];   
    }

    void dfs(int[] nums, int s, int[] state){
        state[1] += state[0];
        for(int i = s; i < nums.length; i++){
            state[0] ^= nums[i];
            dfs(nums, i + 1, state);
            state[0] ^= nums[i];
        }
    }
}