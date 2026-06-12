class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for(int p: piles) max = Math.max(max, p);
        int l = 1, r = max;
        int ans = 0;
        while(l <= r){
            int mid = l + (r - l)/2;
            int hrs = 0;
            for(int p: piles){
                hrs += Math.ceil((double)p/mid);
            }
            if(hrs <= h){
                ans = mid;
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return ans;
    }
}
