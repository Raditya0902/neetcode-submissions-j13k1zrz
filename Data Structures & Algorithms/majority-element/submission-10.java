class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int num = Integer.MIN_VALUE;
        for(int n: nums){
            if(count == 0){
                num = n;
                count++;
            }else if(num == n){
                count++;
            }else{
                count--;
            }
        }
        return num;
    }
}