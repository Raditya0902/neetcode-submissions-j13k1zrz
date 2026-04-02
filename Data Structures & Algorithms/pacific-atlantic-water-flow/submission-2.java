class Solution {
    int rows;
    int cols;
    int[] dr = {-1,0,1,0};
    int[] dc = {0,1,0,-1};
    boolean[][] pac;
    boolean[][] atl;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.rows = heights.length;
        this.cols = heights[0].length;
        this.pac = new boolean[rows][cols];
        this.atl  = new boolean[rows][cols];
        for(int row = 0; row < rows; row++){
            dfs(row, 0, pac, heights);
            dfs(row, cols - 1, atl, heights);
        }
        for(int col = 0; col < cols; col++){
            dfs(0, col, pac, heights);
            dfs(rows - 1, col, atl, heights);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(pac[i][j] && atl[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }

    void dfs(int i, int j, boolean[][] vis, int[][] heights){
        vis[i][j] = true;
        for(int d = 0; d < 4; d++){
            int nr = i + dr[d];
            int nc = j + dc[d];
            if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && !vis[nr][nc] && heights[nr][nc] >= heights[i][j]){
                dfs(nr, nc, vis, heights);
            }
        }
    }
}
