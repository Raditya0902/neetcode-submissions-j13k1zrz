class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int cs  = 0;
        for(int i = 0; i < nums.length; i++){
            cs += nums[i];
            max = Math.max(cs, max);
            if(cs < 0) cs = 0;
        }
        return max;
    }
}
