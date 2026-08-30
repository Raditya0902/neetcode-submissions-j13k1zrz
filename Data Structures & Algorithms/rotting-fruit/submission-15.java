class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int fresh = 0, time = 0;
        int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1) fresh++;
                else if(grid[i][j] == 2) q.offer(new int[]{i,j});
            }
        }

        if(fresh == 0) return time;

        while((fresh > 0) && !q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] cell = q.poll();
                int r = cell[0], c = cell[1];
                for(int[] dir: dirs){
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        q.offer(new int[]{nr,nc});
                        fresh--;
                    }
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}
