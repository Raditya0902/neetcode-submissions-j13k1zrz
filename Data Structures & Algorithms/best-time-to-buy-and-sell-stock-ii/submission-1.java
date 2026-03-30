class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int bp = Integer.MAX_VALUE, sp = 0;
        for(int num: prices){
            if(bp > num){
                bp = num;
            }else{
                sp += (num - bp);
                bp = num;
            }
        }
        return sp;
    }
}