class Solution {
    public int maxProduct(int[] nums) {
        int product = 1, max = nums[0];
        for(int i = 0; i < nums.length; i++){
            product *= nums[i];
            max = Math.max(product, max);
            if(product == 0) product = 1;
        }
        product = 1;
        for(int i = nums.length - 1; i > -1; i--){
            product *= nums[i];
            max = Math.max(product, max);
            if(product == 0) product = 1;
        }
        return max;
    }
}
