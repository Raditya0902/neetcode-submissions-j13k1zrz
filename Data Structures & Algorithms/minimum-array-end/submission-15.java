class Solution {
    public long minEnd(int n, int x) {
        long ans = x;
        long bit = 1L, k = (long)n - 1;
        for(; k > 0; bit <<= 1){
            if((ans & bit) == 0){
                if((k & 1) == 1){
                    ans |= bit;
                }
                k >>= 1;
            }
        }
        return ans;
    }
}