class Solution {
    public int maxProfit(int[] nums) {
        int l = 0;
        int profit = 0;
        for(int r = 1; r < nums.length; r++){
            if(nums[r] > nums[l]){
                profit = Math.max(profit, nums[r] - nums[l]);
            }else{
                l = r;
            }
        }
        return profit;
    }
}
