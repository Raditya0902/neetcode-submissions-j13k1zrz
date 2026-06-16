class Solution {
    int[][] grid;
    int n;
    int m;
    boolean[][] vis;
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        this.m = grid[0].length;
        this.vis = new boolean[n][m];
        int area = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    area = Math.max(area, dfs(i,j));
                }
            }
        }
        return area;
    }

    int dfs(int i, int j){
        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 0 || vis[i][j]) return 0;
        vis[i][j] = true;
        return 1 + dfs(i-1, j) + dfs(i, j+1) + dfs(i+1, j) + dfs(i, j-1);
    }
}
