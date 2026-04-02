class Solution {
    int[][] grid;
    boolean[][] vis;
    int rows;
    int cols;
    public void islandsAndTreasure(int[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.vis = new boolean[rows][cols];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 0){
                    vis[i][j] = true;
                    q.offer(new int[]{i,j});
                }
            }
        }

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        
        int dist = 0;
        while(!q.isEmpty()){
            int size= q.size();
            for(int i = 0; i < size; i++){
                int[] curr = q.poll();
                int r = curr[0], c = curr[1];
                grid[r][c] = dist;
                for(int k = 0; k < 4; k++){
                    int nr = r + dr[k];
                    int nc = c + dc[k];
                    if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && !vis[nr][nc] && grid[nr][nc] == Integer.MAX_VALUE){
                        vis[nr][nc] = true;
                        q.offer(new int[]{nr, nc});
                    }

                }
            }
            dist++;
        } 
    }
}
