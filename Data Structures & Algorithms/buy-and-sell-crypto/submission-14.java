class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int bp = prices[0];
        for(int i = 0; i < prices.length; i++){
            int profit = 0;
            if(bp < prices[i]){
                profit = prices[i] - bp;
            }else{
                bp = prices[i];
            }
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }
}
