class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1, zeroes = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0) zeroes++;
            else{
                product *= nums[i];
            }
        }
        if(zeroes > 1) return new int[nums.length];
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(zeroes > 0){
                res[i] = (nums[i] == 0) ? product : 0;
            }else{
                res[i] = product / nums[i];
            }
        }
        return res;
    }
}  
