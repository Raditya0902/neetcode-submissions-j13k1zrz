class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        int c1 = 0, c2 = 0;
        int n1 = Integer.MIN_VALUE, n2 = Integer.MIN_VALUE;
        for(int n: nums){
            if(n1 == n) c1++;
            else if(n2 == n) c2++;
            else if(c1 == 0) {
                c1++;
                n1 = n;
            }else if(c2 == 0){
                c2++;
                n2 = n;
            }else{
                c1--;
                c2--;
            }
        }

        int req = nums.length / 3;
        c1 = 0; c2 = 0;
        for(int n: nums){
            if(n1 == n) c1++;
            else if(n2 == n) c2++;
        }
        if(c1 > req) ls.add(n1);
        if(c2 > req) ls.add(n2);
        return ls;
    }
}