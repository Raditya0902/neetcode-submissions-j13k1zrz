class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int l = 0, r = nums.length - 1;
        reverse(nums, l, r);
        reverse(nums, l, k - 1);
        reverse(nums, k, r);
    }

    void reverse(int[] nums, int l, int r){
        while(l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}