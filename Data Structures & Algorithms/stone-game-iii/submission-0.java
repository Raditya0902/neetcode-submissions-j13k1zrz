class Solution {
    int[] dp;
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        int res = solve(stoneValue, 0);
        if(res > 0) return "Alice";
        return res < 0 ? "Bob" : "Tie";
    }

    int solve(int[] vals, int i){
        if(i >= vals.length) return 0;
        if(dp[i] != Integer.MIN_VALUE) return dp[i];
        int best = Integer.MIN_VALUE, sum = 0;
        for(int k = 0; k < 3 && i + k < vals.length; k++){
            sum += vals[i + k];
            best = Math.max(best, sum - solve(vals, i + k + 1));
        }
        return dp[i] = best;
    }
}