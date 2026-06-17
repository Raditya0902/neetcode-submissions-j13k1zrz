class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
        boolean[][] vis = new boolean[m][n];

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0) q.offer(new int[]{i,j});
            }
        }

        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0; s < size; s++){
                int[] cell = q.poll();
                int r = cell[0], c = cell[1];
                for(int[] dir: dirs){
                    int ni = r + dir[0];
                    int nj = c + dir[1];
                    if(ni >= 0 && ni < m && nj >= 0 && nj < n && !vis[ni][nj] && grid[ni][nj] == Integer.MAX_VALUE){
                        vis[ni][nj] = true;
                        grid[ni][nj] = 1 + grid[r][c];
                        q.offer(new int[]{ni,nj});
                    }
                }
            }
        }
    }
}
