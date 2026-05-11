class Solution {
    public int maxProfit(int[] prices) {
        int i = 0, j = i + 1;
        int profit = 0;
        while(j < prices.length){
            if(prices[i] > prices[j]){
                i = j;
            }else{
                profit = Math.max(prices[j] - prices[i], profit);
            }
            j++;
        }
        return profit;
    }
}
