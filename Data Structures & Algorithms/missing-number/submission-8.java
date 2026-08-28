class Solution {
    public int missingNumber(int[] nums) {
        int xor = 0;
        for(int n: nums) xor ^= n;
        for(int i = 0; i <= nums.length; i++) xor ^= i;
        return xor;
    }
}
