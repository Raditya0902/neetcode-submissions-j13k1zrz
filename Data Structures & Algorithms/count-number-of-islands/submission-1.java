class Solution {
    char[][] grid;
    boolean[][] vis;
    int rows;
    int cols;
    public int numIslands(char[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.vis = new boolean[rows][cols];
        int count = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    count++;
                    dfs(i,j);
                }
            }
        }
         return count;
    }

    void dfs(int i, int j){
        if(i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == '0' || vis[i][j]) return;
        vis[i][j] = true;
        dfs(i-1, j);
        dfs(i, j+1);
        dfs(i+1,j);
        dfs(i,j-1);
    }
}
