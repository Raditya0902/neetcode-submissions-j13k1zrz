class Solution {
    public int maxProfit(int[] nums) {
        int l = 0;
        int profit = Integer.MIN_VALUE;
        for(int r = 1; r < nums.length; r++){
            if(nums[r] > nums[l]){
                profit = Math.max(profit, nums[r] - nums[l]);
            }else{
                l = r;
            }
        }
        return profit == Integer.MIN_VALUE ? 0 : profit;
    }
}
