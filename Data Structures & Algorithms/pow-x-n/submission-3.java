class Solution {
    public double myPow(double x, int n) {
        if(x == 0) return 0.0;
        if(n == 0) return 1.0;
        double res = helper(x, Math.abs(n));
        return (n < 0) ? 1/res : res;
    }

    double helper(double x, int n){
        if(x == 0) return 0.0;
        if(n == 0) return 1.0;
        double half = helper(x, n/2);
        if(n % 2 == 1) return half * half * x;
        return half * half;
    }

}
