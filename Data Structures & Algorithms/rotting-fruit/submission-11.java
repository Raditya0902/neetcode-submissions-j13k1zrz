class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    vis[i][j] = true;
                    q.offer(new int[]{i,j});
                }else if(grid[i][j] == 1) fresh++;
            }
        }
        
        if(fresh == 0) return 0;
        
        int time = 0;
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        while(fresh > 0 && !q.isEmpty()){
            int size = q.size();
            for(int s = 0; s < size; s++){
                int[] curr = q.poll();
                int r = curr[0], c = curr[1];
                for(int i = 0; i < 4; i++){
                    int nr = r + dr[i], nc = c + dc[i];
                    if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1 && !vis[nr][nc]){
                        vis[nr][nc] = true;
                        fresh--;
                        q.offer(new int[]{nr,nc});
                    }
                }
            }
            time++;
        }


        return fresh == 0 ? time: -1;

    }
}
