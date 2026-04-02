class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        boolean vis[][] = new boolean[rows][cols];
        Queue<int[]> q = new LinkedList<>();
        int[] dr = {-1,0,1,0};    
        int[] dc = {0,1,0,-1};

    
        for(int j = 0; j < cols; j++){
            if(board[0][j] == 'O'){
                vis[0][j] = true;
                q.offer(new int[]{0,j});
            }
            if(board[rows - 1][j] == 'O'){
                vis[rows-1][j] = true;
                q.offer(new int[]{rows-1,j});
            }
        }

        for(int i = 1; i < rows - 1; i++){
            if(board[i][0] == 'O'){
                vis[i][0] = true;
                q.offer(new int[]{i,0});
            }
            if(board[i][cols-1] == 'O'){
                vis[i][cols-1] = true;
                q.offer(new int[]{i,cols-1});
            }
        }

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && !vis[nr][nc] && board[nr][nc] == 'O'){
                    vis[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
            
        }

        for(int i = 1; i < rows - 1; i++){
            for(int j = 1; j < cols - 1; j++){
                if(board[i][j] == 'O' && !vis[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }
}
