class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int curMax = 0;
        int curMin = 0;
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE; 
        int total = 0;
        
        for(int x: nums){
            total += x;
            
            curMax = Math.max(x, curMax + x);
            maxSum = Math.max(maxSum, curMax);

            curMin = Math.min(x, curMin + x);
            minSum = Math.min(minSum, curMin);
        }

        if(total < 0) return maxSum;
        return Math.max(maxSum, total - minSum);
    }
}