class Solution {
    int[] t; 
    public int rob(int[] nums) {
        int n = nums.length; 
        t = new int[n + 1];
        Arrays.fill(t, -1);
        f(n, nums);
        return t[n];
    }

    int f(int houses, int[] nums){
        if(houses == 1) return t[houses] = nums[0];
        if(houses == 2) return t[houses] = Math.max(nums[0], nums[1]);
        if(t[houses] != -1) return t[houses];
        int notPick = f(houses - 1, nums);
        int pick = nums[houses-1] + f(houses - 2, nums);
        return t[houses] = Math.max(notPick, pick);
    }
}
