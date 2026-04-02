class Solution {
    int[][] grid;
    boolean[][] vis;
    int rows;
    int cols;

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.vis = new boolean[rows][cols];
        int maxArea = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    int area = dfs(i,j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    int dfs(int i, int j){
        if(i < 0 || j < 0 || i >= rows || j >= cols || vis[i][j] || grid[i][j] == 0) return 0;
        vis[i][j] = true;
        return 1 + dfs(i-1, j) + dfs(i, j+1) + dfs(i+1,j) + dfs(i, j-1);
    }
}
