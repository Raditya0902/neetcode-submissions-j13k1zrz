class Solution {

    public int islandPerimeter(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[][] vis = new int[rows][cols];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1){
                    return dfs(i,j, grid, vis);
                }
            }
        }
        return 0;
    }

    int dfs(int i, int j, int[][] grid, int[][] vis){
        int rows = grid.length, cols = grid[0].length;
        if(i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == 0) return 1;
        if(vis[i][j] == 1) return 0;
        vis[i][j] = 1;
        return dfs(i,j+1, grid,vis) + dfs(i+1, j,grid,vis) + dfs(i, j-1, grid, vis) + dfs(i-1,j, grid, vis);
    }
}