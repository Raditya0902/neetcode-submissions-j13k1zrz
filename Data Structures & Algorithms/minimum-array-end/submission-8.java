class Solution {
    public long minEnd(int n, int x) {
        long ans = x;
        long rem = n - 1;
        long bitInAnswer = 1;
        while(rem > 0){
            if((x & bitInAnswer) == 0){
                if((rem & 1) == 1){
                    ans = ans | (bitInAnswer);
                }
                rem >>= 1;
            }
            bitInAnswer <<= 1;
        }
        return ans;
    }
}