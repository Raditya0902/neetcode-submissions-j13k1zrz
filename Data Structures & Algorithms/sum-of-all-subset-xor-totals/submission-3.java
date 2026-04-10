class Solution {
    int res = 0;
    public int subsetXORSum(int[] nums) {
        backtrack(0, nums, 0);
        return res;
    }

    void backtrack(int idx, int[] nums, int currXor){
        if(idx == nums.length) {
            res += currXor;
            return;
        }

        currXor ^= nums[idx];
        backtrack(idx+1, nums, currXor);
        currXor ^= nums[idx];
        backtrack(idx+1, nums, currXor);
    }
}