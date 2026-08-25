class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = nums.length + 1;
        int l = 0, sum = 0;
        for(int r = 0; r < nums.length; r++){
            sum += nums[r];
            while(sum >= target){
                minLen = Math.min(minLen, r - l + 1);
                sum -= nums[l++];
            }
        }
        return minLen == nums.length + 1 ? 0 : minLen;
    }
}