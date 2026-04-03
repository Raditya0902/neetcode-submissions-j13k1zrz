class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            int val = nums[mid];
            if(val < target){
                l = mid + 1;
            }else if(val >= target){
                r = mid - 1;
            }
        }
        return l;
    }
}