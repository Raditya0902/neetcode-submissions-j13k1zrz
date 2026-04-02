class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] vis = new boolean[rows][cols];
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1) fresh++;
                else if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }
            }
        }
        int time = 0;
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        while(fresh > 0 && !q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] curr = q.poll();
                int r = curr[0], c = curr[1];
                for(int k = 0; k < 4; k++){
                    int nr = r + dr[k], nc = c + dc[k];
                    if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && !vis[nr][nc] && grid[nr][nc] == 1){
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
