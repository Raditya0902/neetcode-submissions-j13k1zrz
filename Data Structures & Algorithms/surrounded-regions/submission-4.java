class Solution {
    char[][] board;
    int m;
    int n;
    int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};

    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        this.board = board;

        for(int i = 0; i < m; i++){
            if(board[i][0] == 'O') dfs(i, 0);
        }
        
        for(int j = 1; j < n; j++){
            if(board[0][j] == 'O') dfs(0, j);
        }

        for(int i = 1; i < m; i++){
            if(board[i][n-1] == 'O') dfs(i, n-1);
        }

        for(int j = 1; j < n - 1; j++){
            if(board[m-1][j] == 'O') dfs(m-1, j);
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'T') board[i][j] = 'O';
            }
        }
    }

    void dfs(int i, int j){
        board[i][j] = 'T';
        for(int[] dir: dirs){
            int nr = i + dir[0];
            int nc = j + dir[1];
            if(nr >= 0 && nr < m && nc >= 0 && nc < n && board[nr][nc] == 'O'){
                dfs(nr, nc);
            }
        }
    }
}
