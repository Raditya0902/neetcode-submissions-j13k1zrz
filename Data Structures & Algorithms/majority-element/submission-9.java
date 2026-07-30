class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int num = Integer.MIN_VALUE;
        for(int n: nums){
            if(num == n)count++;
            else if(count == 0){
                count++;
                num = n;
            }
            else if(num != n) count--;
        }
        return num;
    }
}