class Solution {
    int[] suffix;
    int[][] dp;
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        suffix = new int[n + 1];
        dp = new int[n+1][n+1];

        for(int i = n - 1; i >= 0; i--){
            suffix[i] = suffix[i+1] + piles[i];
        }

        return solve(0, 1, n);
    }

    int solve(int i, int m, int n){
        if(i >= n) return 0;
        if(i + 2 * m >= n) return suffix[i];
        if(dp[i][m] != 0) return dp[i][m];
        int best = 0;
        for(int x = 1; x <= 2 * m; x++){
            int opp = solve(i + x, Math.max(m,x), n);
            best = Math.max(best, suffix[i] - opp);
        }

        return dp[i][m] = best;
    }
}