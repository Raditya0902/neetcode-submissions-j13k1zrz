class Solution {
    public int maxProfit(int[] prices) {
        int bp = Integer.MAX_VALUE;
        int profit = 0;
        for(int i = 0; i < prices.length; i++){
            if(bp > prices[i]){
                bp = prices[i];
            }else{
                profit += prices[i] - bp;
                bp = prices[i];
            }
        }
        return profit;
    }
}