class Solution {
    public int splitArray(int[] nums, int k) {
        int start = Integer.MIN_VALUE;
        int end = 0;
        int res = -1;
        for(int n: nums){
            start = Math.max(n, start);
            end += n;
        }

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(isValid(nums, k, mid)){
                res = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return res;
    }

    boolean isValid(int[] nums, int k, int capacity){
        int n = nums.length;
        int curr = 1;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
            if(sum > capacity){
                curr++;
                sum = nums[i];
            }
        }
        return curr <= k;

    }
}