class Solution {
    int n;
    int m;
    public boolean exist(char[][] board, String word) {
        this.n = board.length;
        this.m = board[0].length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(dfs(i,j,0,board,word)) return true;
            }
        }

        return false;
    }

    boolean dfs(int i, int j, int idx, char[][] board, String word){
        if(idx == word.length()) return true;
        if(i < 0 || j < 0 || i >= n || j >= m) return false;
        if(board[i][j] == '#' || board[i][j] != word.charAt(idx)) return false;
        char ch = board[i][j];
        board[i][j] = '#';
        boolean res = dfs(i+1,j,idx+1,board,word) ||
                        dfs(i-1,j,idx+1,board,word) ||
                        dfs(i,j+1,idx+1,board,word) ||
                        dfs(i,j-1,idx+1,board,word);
        board[i][j] = ch;
        return res;
    }
}
