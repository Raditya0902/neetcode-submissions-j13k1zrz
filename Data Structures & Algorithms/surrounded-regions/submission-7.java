class Solution {
    int n;
    int m;
    char[][] board;
    int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};

    public void solve(char[][] board) {
        this.board = board;
        this.n = board.length;
        this.m = board[0].length;
        
        for(int i = 0; i < m; i++){
            if(board[0][i] == 'O') dfs(0,i);
        }

        for(int j = 1; j < n; j++){
            if(board[j][m-1] == 'O') dfs(j, m-1);
        }

        for(int i = 0; i < m - 1; i++){
            if(board[n-1][i] == 'O') dfs(n-1, i);
        }

        for(int j = 1; j < n - 1; j++){
            if(board[j][0] == 'O') dfs(j, 0);
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'A') board[i][j] = 'O';
            }
        }
    }

    void dfs(int i, int j){
        board[i][j] = 'A';
        for(int[] dir: dirs){
            int nr = i + dir[0];
            int nc = j + dir[1];
            if(nr >= 0 && nr < n && nc >= 0 && nc < m && board[nr][nc] == 'O'){
                dfs(nr, nc);
            }
        }
    }
}
