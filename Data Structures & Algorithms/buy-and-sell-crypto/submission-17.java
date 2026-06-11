class Solution {
    public int maxProfit(int[] prices) {
        int l = 0, max = 0;
        for(int r = 1; r < prices.length; r++){
            int bp = prices[l];
            if(prices[r] > bp){
                max = Math.max(max, prices[r] - bp);
            }else{
                l = r;
            }
        }
        return max;
    }
}
