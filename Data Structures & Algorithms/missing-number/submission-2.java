class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length, xor = n;
        for(int i = 0; i < n; i++) xor = xor ^ i ^ nums[i];
        return xor;
    }
}
