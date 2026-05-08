class Solution {
    int INF = Integer.MAX_VALUE;
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0){
                    q.offer(new int[]{i, j});
                }
            }
        }

        int[] dr = {-1,0,1,0};
        int[] dc = {0, 1, 0, -1};

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];
            for(int i = 0; i < 4; i++){
                int nr = r + dr[i], nc = c + dc[i];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == INF && !vis[nr][nc]){
                    vis[nr][nc] = true;
                    grid[nr][nc] = 1 + grid[r][c];
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }
}
