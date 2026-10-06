class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int n = nums.length, res = n + 1;

        int sum = 0;
        for(int r = 0; r < n; r++){
            sum += nums[r];
            while(sum >= target){
                res = Math.min(res, r - l + 1);
                sum -= nums[l++];
            }
        }

        return res == n + 1 ? 0 : res;
    }
}