class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n1 = Integer.MIN_VALUE, n2 = Integer.MIN_VALUE;
        int len = nums.length;
        int c1 = 0, c2 = 0;
        List<Integer> ans = new ArrayList<>();
        for(int n: nums){
            if(n1 == n){
                c1++;
            }else if(n2 == n){
                c2++;
            }else if(c1 == 0){
                n1 = n;
                c1++;
            }else if(c2 == 0){
                n2 = n;
                c2++;
            }else if(n1 != n && n2 != n){
                c1--;
                c2--;
            }
        }
        c1 = 0;
        c2 = 0;
        int req = len/3;
        for(int n: nums){
            if(n == n1) c1++;
            else if(n == n2) c2++;
        }
        if(c1 > req) ans.add(n1);
        if(c2 > req) ans.add(n2);
        return ans;
    }
}