class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 0, r = 0;
        int ans = 0;
        for(int wt: weights){
            l = Math.max(l, wt);
            r += wt;
        }
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(canShip(mid, weights, days)){
                ans = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return ans;
    }
    
    boolean canShip(int cap, int[] weights, int days){
        int sum = 0;
        int currDay = 1;
        for(int wt: weights){
            if((sum + wt) > cap){
                sum = 0;
                currDay++;
            }
            sum += wt;
        }
        return currDay <= days;
    }

}