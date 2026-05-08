class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        int time = 0;
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1) fresh++;
                else if(grid[i][j] == 2) {vis[i][j] = true; q.offer(new int[]{i,j});}
            }
        }

        if(fresh == 0) return time;

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
                        q.offer(new int[]{nr, nc});
                        vis[nr][nc] = true;
                        fresh--;
                    }
                }
            }   
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}
