class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int cs  = nums[0];
        for(int i = 1; i < nums.length; i++){
            cs = Math.max(nums[i], cs + nums[i]);
            max = Math.max(cs, max);
        }
        return max;
    }
}
