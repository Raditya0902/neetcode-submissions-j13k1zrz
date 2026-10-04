class Solution {
    public int majorityElement(int[] nums) {
        int n1 = Integer.MIN_VALUE;
        int count = 0;
        for(int num: nums){
            if(n1 == num){
                count++;
            }else if(count == 0){
                n1 = num;
                count++;
            }else{
                count--;
            }
        }
        return n1;
    }
}