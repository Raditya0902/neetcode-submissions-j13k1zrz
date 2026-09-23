class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n1 = Integer.MIN_VALUE, n2 = Integer.MIN_VALUE;
        int c1 = 0, c2 = 0;

        for(int num: nums){
            if(n1 == num) c1++;
            else if(n2 == num) c2++;
            else if(c1 == 0){
                n1 = num;
                c1++;
            }else if(c2 == 0){
                n2 = num;
                c2++;
            }else{
                c1--;
                c2--;
            }
        }
        
        int n = nums.length / 3;
        c1 = c2 = 0;
        List<Integer> res = new ArrayList<>();
        for(int num: nums){
            if(n1 == num) c1++;
            if(n2 == num) c2++;
        }

        if(c1 > n) res.add(n1);
        if(c2 > n) res.add(n2);

        return res;
    }
}