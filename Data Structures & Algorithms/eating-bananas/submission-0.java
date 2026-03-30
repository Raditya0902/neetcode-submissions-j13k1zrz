class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        int ans = 0;
        for(int num: piles){
            if(max < num) max = num;
        }
        int l = 1, h1 = max;
        while(l <= h1){
            int mid = (l + h1)/2;
            int time = 0;
            for(int p: piles){
                time += Math.ceil((double)p/mid);
            }
            if(time <= h){
                ans = mid;
                h1 = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return ans;
    }
}
