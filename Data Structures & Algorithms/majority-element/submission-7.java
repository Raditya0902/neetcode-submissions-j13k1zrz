class Solution {
    public int majorityElement(int[] nums) {
        int n1 = Integer.MIN_VALUE;
        int c1 = 0;

        for(int n: nums){
            if(n1 == n){
                c1++;
            } else if(c1 == 0){
                n1 = n;
                c1++;
            }else{
                c1--;
            }
        }

        return n1;
    }
}