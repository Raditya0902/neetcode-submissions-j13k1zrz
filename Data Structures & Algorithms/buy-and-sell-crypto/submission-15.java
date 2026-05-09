class Solution {
    public int maxProfit(int[] prices) {
        int bp = Integer.MAX_VALUE, profit = 0;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < bp) bp = prices[i];
            else{
                profit = Math.max(prices[i] - bp, profit);
            }
        }
        return profit;
    }
}
