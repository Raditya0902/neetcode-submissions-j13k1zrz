class Solution {
    public int hammingWeight(int n) {
        int res = 0;
        int bitShift = 0;
        while(bitShift < 32){
            res += (n & (1 << bitShift)) != 0 ? 1:0;
            bitShift++;
        }
        return res;
    }
}
