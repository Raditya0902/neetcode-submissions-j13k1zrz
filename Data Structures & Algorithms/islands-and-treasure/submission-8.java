class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0) {
                    q.offer(new int[]{i,j});
                }
            }
        }

        while(!q.isEmpty()){
            int[] cell = q.poll();
            int r = cell[0], c = cell[1];
            for(int[] dir: dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == Integer.MAX_VALUE && !vis[nr][nc]){
                    q.offer(new int[]{nr,nc});
                    grid[nr][nc] = 1 + grid[r][c];
                    vis[nr][nc] = true;
                }
            }
        }
    }
}
