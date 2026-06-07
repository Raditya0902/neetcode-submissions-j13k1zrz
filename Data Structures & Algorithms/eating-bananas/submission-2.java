class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for(int p: piles) max = Math.max(max, p);
        int left = 0, right = max, ans = 0;
        while(left <= right){
            int mid = left + (right - left) / 2;
            int time = 0;
            for(int p: piles){
                time += Math.ceil((double)p/mid);
            }
            if(time <= h){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return ans;
    }
}
