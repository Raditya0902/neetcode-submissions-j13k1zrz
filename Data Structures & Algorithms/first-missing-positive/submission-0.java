class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = 1;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == n) n++;
        }
        return n;
    }
}