class Solution {
    int dp[];
    public int integerBreak(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp,-1);
        return solve(n);
    }

    int solve(int n){
        if(n <= 1) return n;
        if(dp[n] != -1) return dp[n];
        int max = 0;
        for(int j = 1; j < n; j++){
            max = Math.max(max, Math.max(j * (n - j), j * solve(n - j)));
        }
        return dp[n] = max;
    }
}