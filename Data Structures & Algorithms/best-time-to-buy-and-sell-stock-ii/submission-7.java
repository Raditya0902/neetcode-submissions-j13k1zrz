class Solution {
    public int maxProfit(int[] prices) {
        int bp = Integer.MAX_VALUE;
        int profit = 0;
        for(int p: prices){
            if(bp > p) bp = p;
            else{
                profit += p - bp;
                bp = p;
            }
        }
        return profit;
    }
}