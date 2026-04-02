class Solution {
    int rows;
    int cols;
    public void islandsAndTreasure(int[][] grid) {
        this.rows = grid.length;
        this.cols = grid[0].length;
        boolean[][] vis = new boolean[rows][cols];
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 0){
                    vis[i][j] = true;
                    q.offer(new int[]{i,j});
                }
            }
        }

        int dist = 0;
        int[][] drc = {{-1,0},{0,1},{1,0},{0,-1}};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] curr = q.poll();
                int r = curr[0], c = curr[1];
                grid[r][c] = dist;
                for(int[]d: drc){
                    int nr = r + d[0], nc = c + d[1];
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
