class Solution {
    public int maxProfit(int[] prices) {
        int bp = Integer.MAX_VALUE;
        int profit = 0;
        for(int num: prices){
            if(bp > num){
                bp = num;
            }else{
                profit = Math.max(profit, num - bp);
            }
        }
        return profit;
    }
}
