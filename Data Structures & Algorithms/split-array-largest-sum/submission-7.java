class Solution {
    public int splitArray(int[] nums, int k) {
        int l = -1, r = 0, ans = -1;
        for(int n: nums){
            l = Math.max(l, n);
            r += n;
        }

        while(l <= r){
            int mid = l + (r - l) / 2;
            if(poss(nums, mid, k)){
                ans = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return ans;
    }

    boolean poss(int[] nums, int mid, int k){
        int sum = 0, subs = 1;
        for(int n: nums){
            if((sum + n) > mid){
                subs++;
                sum = 0;
            }
            sum += n;
        }
        return subs <= k;
    }
}