class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
        boolean[][] vis = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0, time = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                    vis[i][j] = true;
                }
                if(grid[i][j] == 1) fresh++;
            }
        }

        if(fresh == 0) return time;

        while(fresh > 0 && !q.isEmpty()){
            int size = q.size();
            for(int s = 0; s < size; s++){
                int[] cell = q.poll();
                int r = cell[0], c = cell[1];
                for(int[] dir: dirs){
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1 && !vis[nr][nc]){
                        vis[nr][nc] = true;
                        fresh--;
                        q.offer(new int[]{nr,nc});
                    }
                }
            }
            time++;
        }

        return fresh == 0 ? time : -1;
    }
}
