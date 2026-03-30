class Solution {
    public int maxProfit(int[] prices) {
        int l = 0, max = Integer.MIN_VALUE;
        for(int r = 1; r < prices.length; r++){
            if(prices[r] <= prices[l]){
                l = r;
            }else{
                max = Math.max(max, prices[r]-prices[l]);
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}
