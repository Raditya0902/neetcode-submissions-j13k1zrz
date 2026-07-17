class Solution {
    public int majorityElement(int[] nums) {
        int c1 = 0;
        int n1 = Integer.MIN_VALUE;
        for(int num: nums){
            if(n1 == num){
                c1++;
            }else if(n1 != num && c1 == 0){
                n1 = num;
                c1++;
            }else{
                c1--;
            }
        }
        return n1;
    }
}