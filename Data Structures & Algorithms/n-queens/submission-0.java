class Solution {
    List<List<String>> res = new ArrayList<>();
    char[][] board;
    public List<List<String>> solveNQueens(int n) {
        board = new char[n][n];

        for(int i = 0; i < n; i++){
            Arrays.fill(board[i], '.');
        }

        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1];
        boolean[] diag2 = new boolean[2 * n - 1];

        dfs(0, n, cols, diag1, diag2);
        return res;
    }

    void dfs(int row, int n, boolean[] cols, boolean[] diag1, boolean[] diag2){
        if(row == n){
            res.add(convertBoard());
            return;
        }

        for(int col = 0; col < n; col++){
            int d1 = row - col + (n - 1);
            int d2 = row + col;
            if(cols[col] || diag1[d1] || diag2[d2]) continue;

            board[row][col] = 'Q';
            cols[col] = true;
            diag1[d1] = true;
            diag2[d2] = true;

            dfs(row + 1, n, cols, diag1, diag2);

            board[row][col] = '.';
            cols[col] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }

    List<String> convertBoard(){
        List<String> ls = new ArrayList<>();
        for(char[] row: board){
            ls.add(new String(row));
        }
        return ls;
    }
}
