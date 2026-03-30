class Solution {
    public int missingNumber(int[] nums) {
        int xor = 0, n = nums.length;
        for(int i = 0; i <= n; i++) xor ^= i;
        for(int i = 0; i < n; i++) xor ^= nums[i];
        return xor;
    }
}
