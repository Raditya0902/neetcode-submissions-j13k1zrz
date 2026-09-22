class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for(int n: nums) total += n;
        if(Math.abs(target) > total) return 0;
        if((target + total) %2 != 0) return 0;
        int n = nums.length;
        int p = (target + total) / 2;

        int[][] t = new int[n+1][p+1];

        for(int j = 0; j <= p; j++) t[0][j] = 0;
        t[0][0] = 1;
        
        for(int i = 1; i <= n; i++){
            if(nums[i-1] == 0){
                t[i][0] = 2 * t[i-1][0];
            }else{
                t[i][0] = t[i-1][0];
            }
            for(int j = 1; j <= p; j++){
                if(j >= nums[i-1]){
                    t[i][j] = t[i-1][j] + t[i-1][j - nums[i-1]];
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t[n][p];
    }
}
