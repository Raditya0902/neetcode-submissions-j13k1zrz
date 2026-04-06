class Solution {
    int[] t;
    public int tribonacci(int n) {
        t = new int[n+1];
        Arrays.fill(t, -1);
        return f(n);
    }

    int f(int n){
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        if(t[n] != -1) return t[n];
        return t[n] = f(n-1) + f(n-2) + f(n-3);
    }
}