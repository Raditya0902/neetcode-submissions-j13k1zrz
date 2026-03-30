class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int num: nums) sum += num;
        if(sum < target) return 0;
        if((sum+target)<0 || ((sum+target) % 2) != 0) return 0;
        int required = (sum + target) / 2;
        int[][] t = new int[n + 1][required + 1];
        for(int j = 0; j < required + 1; j++){
            t[0][j] = 0;
        }
        t[0][0] = 1;
        for(int i = 1; i < n + 1; i++){
            if (nums[i - 1] == 0) {
                t[i][0] = 2 * t[i - 1][0];
            } else {
                t[i][0] = t[i - 1][0];
            }
            for(int j = 1; j < required + 1; j++){
                if(nums[i - 1] <= j){
                    t[i][j] = t[i-1][j] + t[i-1][j-nums[i-1]];
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][required];
    }
}
