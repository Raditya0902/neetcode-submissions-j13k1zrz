class Solution {
    public double myPow(double x, int n) {
        if(x == 1.0) return 1.0;
        if(n == 0) return 1.0;
        double ans = f(x, n);
        return n < 0 ? 1 / ans : ans;
    }

    double f(double x, int n){
        if(x == 1.0) return 1.0;
        if(n == 0) return 1.0;
        if(n % 2 == 0) return f(x * x, n/2);
        return x * f(x * x, n/2);
    }
}
