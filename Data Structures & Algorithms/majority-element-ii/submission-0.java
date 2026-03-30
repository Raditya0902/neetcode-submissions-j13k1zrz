class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int num1 = -1, num2 = -1, count1= 0, count2 = 0;
        for(int num: nums){
            if(num == num1){
                count1++;
            }else if(num == num2){
                count2++;
            }else if(count1 == 0){
                num1 = num;
                count1 = 1;
            }else if(count2 == 0){
                num2 = num;
                count2 = 1;
            }else{
                count1--;
                count2--;
            }
        }
        count1 = count2 = 0;
        for(int num: nums){
            if(num == num1) count1++;
            else if(num == num2) count2++;
        }
        List<Integer> ans = new ArrayList<>();
        if(count1 > n / 3) ans.add(num1);
        if(count2 > n / 3) ans.add(num2);
        return ans;
    }
}