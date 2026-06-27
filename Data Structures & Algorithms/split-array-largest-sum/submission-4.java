class Solution {
    public int splitArray(int[] nums, int k) {
        int l = -1, r = 0;
        for(int n: nums){
            l = Math.max(l, n);
            r += n;
        }
        int ans = -1;

        while(l <= r){
            int mid = l + (r - l)/2;
            if(possible(mid, nums, k)){
                ans = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        
        return ans;
    }

    boolean possible(int cap, int[] nums, int k){
        int sum = 0, subs = 1;
        for(int n: nums){
            if(sum + n > cap){
                subs++;
                sum = 0;
            }
            sum += n;
        }
        return subs <= k;
    }
}