class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);
        int pre = 1, suf = 1;
        for(int i = 1; i < n; i++){
            pre *= nums[i-1];
            res[i] = pre;
        }
        for(int i = n - 2; i >= 0; i--){
            suf = suf * nums[i+1];
            res[i] = res[i] * suf;
        }
        return res;
    }
}  
