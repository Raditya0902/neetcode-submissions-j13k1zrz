class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};

        boolean[][] vis = new boolean[m][n];

        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0) q.offer(new int[]{i,j});
            }
        }

        while(!q.isEmpty()){
            int[] cell = q.poll();
            int r = cell[0], c = cell[1];
            for(int[] dir: dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == Integer.MAX_VALUE && !vis[nr][nc]){
                    vis[nr][nc] = true;
                    grid[nr][nc] = 1 + grid[r][c];
                    q.offer(new int[]{nr,nc});
                }
            }
        }
    }
}
