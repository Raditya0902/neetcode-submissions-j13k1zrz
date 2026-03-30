class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int oneWay = f(0, n-1, nums);
        int otherWay = f(1, n, nums);
        return Math.max(oneWay, otherWay);
    }

    int f(int start, int end, int[]nums){
        int prev2 = 0, prev1 = nums[start];
        for(int i = start + 1;i < end; i++){
            int take = nums[i];
            if(i > 1) take += prev2;
            int notTake = prev1;
            int curr = Math.max(take, notTake);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}