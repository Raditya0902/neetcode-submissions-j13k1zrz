class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int res = Integer.MIN_VALUE;
        for(int num: nums){
            if(count == 0){
                count = 1;
                res = num;
            }else if(num == res) count++;
            else count--;
        }
        return res;
    }
}