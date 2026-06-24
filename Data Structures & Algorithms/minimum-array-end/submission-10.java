class Solution {
    public long minEnd(int n, int x) {
        long ans = x;
        long rem = n - 1;
        long bitInAns = 1;
        
        while(rem > 0){
            while((x & bitInAns) != 0) bitInAns <<= 1;
                if(((rem & 1) == 1)){
                    ans = ans | bitInAns;
                }
                rem >>= 1;
            bitInAns <<= 1;
        }
        return ans;
    }
}