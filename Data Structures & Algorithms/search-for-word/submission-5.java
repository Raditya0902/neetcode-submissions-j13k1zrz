class Solution {
    int n;
    int m;
    public boolean exist(char[][] board, String word) {
        this.n = board.length;
        this.m = board[0].length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(dfs(0,i,j,board,word)) return true;
            }
        }
        
        return false;
    }

    boolean dfs(int idx, int r, int c, char[][] board, String word){
        if(idx == word.length()) return true;
        if(r < 0 || c < 0 || r >= n || c >= m || board[r][c] == '#' || board[r][c] != word.charAt(idx)) return false;
        board[r][c] = '#';
        boolean res = dfs(idx+1, r+1, c, board, word) || dfs(idx+1, r-1, c, board, word) || dfs(idx+1, r, c+1, board, word) || dfs(idx+1, r, c-1,board, word);
        board[r][c] = word.charAt(idx);
        return res;
    }
}
