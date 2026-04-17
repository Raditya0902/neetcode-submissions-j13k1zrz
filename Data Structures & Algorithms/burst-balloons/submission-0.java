class Solution {
    int[] arr;
    int[][] memo;
    public int maxCoins(int[] nums) {
        int n = nums.length;
        arr = new int[n+2];
        arr[0] = arr[n+1] = 1;

        for(int i = 0; i < n; i++) arr[i+1] = nums[i];

        memo = new int[n+2][n+2];
        for(int[] row: memo) Arrays.fill(row, -1);
        return solve(0, n + 1);
    }

    int solve(int l, int r){
        if(l + 1 == r) return 0;
        if(memo[l][r] != -1) return memo[l][r];
        int ans = 0;
        for(int k = l + 1; k < r; k++){
            ans = Math.max(ans, solve(l, k) + arr[l] * arr[k] * arr[r] + solve(k, r));
        }
        return memo[l][r] = ans;
    }
}
