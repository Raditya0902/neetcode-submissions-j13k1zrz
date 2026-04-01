class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = Integer.MIN_VALUE;
        int right = 0;
        for(int w: weights){
            left = Math.max(w, left);
            right += w;
        }
        while(left < right){
            int mid = left + (right - left)/2;
            if(canShip(weights, days, mid)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    boolean canShip(int[] weights, int days, int capacity){
        int currW = 0;
        int nowDays = 1;
        for(int w: weights){
            if(currW + w > capacity){
                nowDays++;
                currW = 0;
            }
            currW += w;
        }

        return nowDays <= days;
    }
}