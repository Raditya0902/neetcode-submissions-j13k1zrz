class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(count == 0){
                count++;
                ans = nums[i];
            }
            else if(nums[i] == ans){
                count++;
            }
            else{
                count--;
            }
        }
        return ans;
    }
}