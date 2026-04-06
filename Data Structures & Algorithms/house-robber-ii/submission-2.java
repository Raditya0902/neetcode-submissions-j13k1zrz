class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);
        
        int[]t1 = new int[n];
        int[]t2 = new int[n];

        Arrays.fill(t1,-1);
        Arrays.fill(t2,-1);
        int[] nums1 = new int[n-1];
        int[] nums2 = new int[n-1];
        for(int i = 0; i < n - 1; i++){
            nums1[i] = nums[i];
            nums2[i] = nums[i+1];
        }

        return Math.max(f(n-1, nums1, t1), f(n-1, nums2, t2));
    }

    int f(int houses, int[] nums, int[] t){
        if(houses == 1) return t[houses] = nums[0];
        if(houses == 2) return t[houses] = Math.max(nums[0], nums[1]);
        if(t[houses] != -1) return t[houses];
        int notPick = f(houses - 1, nums, t);
        int pick = nums[houses-1] + f(houses - 2, nums, t);
        return t[houses] = Math.max(notPick, pick);
    }
}
