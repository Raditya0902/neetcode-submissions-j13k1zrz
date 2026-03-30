class Solution {
    int rows;
    int cols; 
    public void islandsAndTreasure(int[][] grid) {
        rows = grid.length; cols = grid[0].length;
        int[][] vis = new int[rows][cols];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 0){
                    vis[i][j] = 1;
                    q.add(new int[]{i,j});
                }
            }
        }
        int dist = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] curr = q.poll();
                int r = curr[0], c = curr[1];
                grid[r][c] = dist;
                addRoom(r,c+1, grid, vis, q);
                addRoom(r+1,c, grid, vis, q);
                addRoom(r,c-1, grid, vis, q);
                addRoom(r-1,c, grid, vis, q);
            }
            dist++;
        }
    }

    void addRoom(int r, int c, int[][] grid, int[][] vis, Queue<int[]> q){
        if(r < 0 || r >= rows || c < 0 || c >= cols || vis[r][c] == 1 || grid[r][c] == -1){
            return;
        }
        vis[r][c] = 1;
        q.add(new int[]{r,c});
    }
}
