class Solution {
    public long minEnd(int n, int x) {
        long ans = x;
        long k = n - 1;
        for(long bit = 1; k > 0; bit <<= 1){
            if((x & bit) == 0){
                if((k & 1) == 1){
                    ans |= bit;
                }
                k >>= 1;
            }
        }

        return ans;
    }
}