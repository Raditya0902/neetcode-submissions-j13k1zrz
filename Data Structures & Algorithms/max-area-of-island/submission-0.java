class Solution {

    int[][] grid;
    int[][] vis;
    int rows;
    int cols;

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        rows = grid.length; cols = grid[0].length;
        this.vis = new int[rows][cols];
        int max = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1 && vis[i][j] == 0){
                    int area = dfs(i,j);
                    max = Math.max(max, area);
                }
            }
        }
        return max;
    }

    int dfs(int i, int j){
        if(i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == 0) return 0;
        if(vis[i][j] == 1) return 0;
        vis[i][j] = 1;
        return 1 + dfs(i,j+1) + dfs(i+1,j) + dfs(i,j-1) + dfs(i-1,j);
    }
}
