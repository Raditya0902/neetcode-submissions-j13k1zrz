class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int minSum = Integer.MAX_VALUE;
        int maxSum = Integer.MIN_VALUE;
        int curMax = 0, curMin = 0, total = 0;
        for(int x: nums){
            total += x;
            
            curMax = Math.max(x, curMax + x);
            maxSum = Math.max(maxSum, curMax);

            curMin = Math.min(x, curMin + x);
            minSum = Math.min(minSum, curMin);
        }

        if(maxSum < 0) return maxSum;
        return Math.max(maxSum, total - minSum);
    }
}