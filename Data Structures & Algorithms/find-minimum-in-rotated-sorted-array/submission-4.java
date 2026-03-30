class Solution {
    public int findMin(int[] nums) {
        int l = 0, h = nums.length - 1;
        int res = nums[0];
        while(l <= h){
            if(nums[l] < nums[h]) {res = Math.min(res, nums[l]); break;}
            int mid = (l + h)/2;
            res = Math.min(res, nums[mid]);
            if(nums[mid] >= nums[l]){
                l = mid + 1;
            }else{
                h = mid - 1;
            }
        }
        return res;
    }
}
