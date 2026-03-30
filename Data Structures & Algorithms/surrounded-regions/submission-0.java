class Solution {
        int rows, cols;
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
    void dfs(int r, int c, char[][] board){
        if(r < 0 || r >= rows || c < 0 || c >= cols || board[r][c] != 'O'){
             return;
        }
        board[r][c] = 'T';
        for(int i = 0; i < 4; i++){
            int nr = r + delRow[i], nc = c + delCol[i];
            dfs(nr, nc, board);
        }

    }

    public void solve(char[][] board) {
        rows = board.length; cols = board[0].length;

        for(int c = 0; c < cols; c++){
            dfs(0,c, board);
            dfs(rows-1,c,board);
        }

        for(int r = 1; r < rows -1; r++){
            dfs(r,0, board);
            dfs(r,cols-1,board);
        }

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
            }
        }

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == 'T') board[i][j] = 'O';
            }
        }
    }
}
