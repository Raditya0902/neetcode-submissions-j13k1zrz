class Solution {
    int[][] memo;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        memo = new int[n][2];
        for(int[] row: memo) Arrays.fill(row, -1);
        return dfs(0, 1, prices);
    }

    int dfs(int i, int buy, int[] prices){
        if(i >= prices.length) return 0;
        if(memo[i][buy] != -1) return memo[i][buy];
        int ans;
        if(buy == 1){
            ans = Math.max(-prices[i] + dfs(i+1, 0, prices), dfs(i+1, 1, prices));
        }else{
            ans = Math.max(prices[i] + dfs(i+2, 1, prices), dfs(i + 1, 0, prices));
        }
        return memo[i][buy] = ans;
    }
}
