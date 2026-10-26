class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = -1;
        int ans = 0;
        for(int p: piles){
            right = Math.max(p, right);
        }
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            int total = 0;
            for(int p: piles) total += Math.ceil(p/(double)mid);
            if(total <= h){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return ans;
    }
}
