class Solution {
    char[][] grid;
    int n, m;
    boolean[][] vis;
    public int numIslands(char[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        this.m = grid[0].length;
        this.vis = new boolean[n][m];
        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    dfs(i,j);
                    count++;
                }
            }
        }

        return count;
    }

    void dfs(int i, int j){
        if(i < 0 || j < 0 || i >= n || j >= m || vis[i][j] || grid[i][j] == '0') return;
        vis[i][j] = true;
        dfs(i-1,j);
        dfs(i,j+1);
        dfs(i+1,j);
        dfs(i,j-1); 
    }
}
