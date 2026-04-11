class Solution {
    public int jump(int[] nums) {
        int res = 0;
        int far = 0;
        int currEnd = 0;
        for(int i = 0; i < nums.length - 1; i++){
            far = Math.max(far, nums[i] + i);
            if(i == currEnd){
                res++;
                currEnd = far;
            }
        }
        return res;
    }
}
