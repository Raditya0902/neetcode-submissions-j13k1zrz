class Solution {
    public int removeDuplicates(int[] nums) {
        int l = 0;
        for(int r = 0; r < nums.length; r++){
            if(nums[l] != nums[r]){
                nums[++l] = nums[r];
            }
        }
        return l + 1;
    }
}