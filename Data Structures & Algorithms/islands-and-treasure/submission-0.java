class Solution {
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    int INF = 2147483647;
    int ROWS, COLS;
    public void islandsAndTreasure(int[][] grid) {
        ROWS = grid.length; COLS = grid[0].length;
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(grid[i][j] == INF){
                    grid[i][j] = bfs(grid, i,j);
                }
            }
        }
    }
    int bfs(int[][] grid, int i, int j){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        boolean[][] vis = new boolean[ROWS][COLS];
        vis[i][j] = true;
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int k = 0; k < size; k++){
                int[] curr = q.poll();
                int row = curr[0], col = curr[1];
                if(grid[row][col] == 0) return steps;
                for(int[] dir: directions){
                    int nr = row + dir[0];
                    int nc = col + dir[1];
                    if(nr >= 0 && nr < ROWS && nc >= 0 && nc < COLS && !vis[nr][nc] && grid[nr][nc] != -1){
                        vis[nr][nc] = true;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
            steps++;
        }
        return INF;
    }

}
