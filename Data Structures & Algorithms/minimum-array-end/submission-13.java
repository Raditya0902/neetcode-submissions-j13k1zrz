class Solution {
    public long minEnd(int n, int x) {
        long ans = x, k = n - 1, bit = 1;
        for(;k>0;bit <<= 1){
            if((x & bit) == 0){
                if((k & 1) == 1) ans |= bit;
                k >>= 1;
            }
        }
        return ans;
    }
}