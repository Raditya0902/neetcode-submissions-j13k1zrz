class Solution {
    int[][] memo;
    int[][] matrix;
    int[][] dir = {{-1,0}, {0, 1}, {1, 0}, {0,-1}};
    int m, n;
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;
        memo = new int[m][n];

        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                ans = Math.max(ans, dfs(i,j));
            }
        }
        return ans;
    }

    int dfs(int i, int j){
        if(memo[i][j] != 0) return memo[i][j];
        int best = 1;
        for(int[] d: dir){
            int nr = i + d[0], nc = j + d[1];
            if(nr >= 0 && nr < m && nc >= 0 && nc < n && matrix[nr][nc] > matrix[i][j]){
                best = Math.max(best, 1 + dfs(nr, nc));
            }
        }
        return memo[i][j] = best;
    }
}
