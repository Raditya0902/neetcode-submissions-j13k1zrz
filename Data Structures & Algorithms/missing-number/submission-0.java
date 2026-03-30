class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int nSum = n * (n + 1) / 2;
        for(int num: nums){
            sum+=num;
        }
        return nSum - sum;
    }
}
