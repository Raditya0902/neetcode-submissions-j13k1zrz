class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 0;
        for(int p: piles) r = Math.max(r, p); 
        int ans = 0;
        while(l <= r){
            int mid = l + (r - l) / 2;
            int time = 0;
            for(int p: piles){
                time += Math.ceil(p/(double)mid);
            }
            if(time <= h){
                ans = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return ans;
    }
}
