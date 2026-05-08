class Solution {
    int[][] grid;
    boolean[][] vis;
    int n, m;

    public int maxAreaOfIsland(int[][] grid) {
        this.n = grid.length;
        this.m = grid[0].length;
        this.grid = grid;
        this.vis = new boolean[n][m];
        int maxArea = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    maxArea = Math.max(maxArea, dfs(i,j));
                }
            }
        }
        return maxArea;
    }

    int dfs(int i, int j){
        if(i < 0 || j < 0 || i >= n || j >= m || vis[i][j] || grid[i][j] == 0){
            return 0;
        }
        vis[i][j] = true;
        return 1 + dfs(i, j + 1) + dfs(i+1,j) + dfs(i, j - 1) + dfs(i-1, j);
    }
}
