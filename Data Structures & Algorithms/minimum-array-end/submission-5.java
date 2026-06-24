class Solution {
    public long minEnd(int n, int x) {
        long res = x;
        long k = n - 1;
        for(int bit = 0; k > 0; bit++){
            if(((res >> bit) & 1L) == 0){
                if((k & 1L) == 1L){
                    res |= 1L << bit;
                }
                k >>= 1;
            }
        }
        return res;
    }
}