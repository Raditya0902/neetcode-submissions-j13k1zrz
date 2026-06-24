class Solution {
    public long minEnd(int n, int x) {// n = 6 && x = 10
        long ans = x; // 10
        long add = n - 1; // 5
        int bit = 0;
        while(add > 0){
            while(((ans >> bit) & 1L) == 1L) bit++;
            if((add & 1L) == 1L){
                ans |= (1L << bit);
            }
            add >>= 1;
            bit++;
        }
        return ans;

    }
}