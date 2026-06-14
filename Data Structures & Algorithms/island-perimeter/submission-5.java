class Solution {
    int[][] grid;
    int n;
    int m;
    boolean vis[][];
    public int islandPerimeter(int[][] grid) {
        this.n = grid.length;
        this.m = grid[0].length;
        this.grid = grid;
        this.vis = new boolean[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    return dfs(i,j);
                }
            }
        }
        return -1;
    }

    int dfs(int i, int j){
        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 0) return 1;
        if(vis[i][j]) return 0;
        vis[i][j] = true;
        return dfs(i + 1, j) + dfs(i - 1, j) + dfs(i, j + 1) + dfs(i, j - 1);
    }
}