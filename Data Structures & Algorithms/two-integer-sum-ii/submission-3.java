class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int[] ans = new int[2];
        while(i < j){
            int sum = nums[i] + nums[j];
            if(sum == target) return new int[]{i + 1, j + 1};
            else if(sum > target) j--;
            else i++;
        }
        return new int[0];
    }
}
