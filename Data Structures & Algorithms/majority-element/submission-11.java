class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int count = 0;
        int val = Integer.MIN_VALUE;
        for(int num: nums){
            if(count == 0){
                val = num;
                count++;
            }
            else if(num == val){
                count++;
            }else if(num != val){
                count--;
            }
        }
        
        return val;
    }
}