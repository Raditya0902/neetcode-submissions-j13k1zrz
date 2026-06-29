class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] queens = new int[n];
        dfs(queens, 0, n, res);
        return res;
    }

    void dfs(int[] queens, int i, int n, List<List<String>> res){
        if(i == n){
            res.add(build(queens, n));
            return;
        }
        for(int j = 0; j < n; j++){
            if(isValid(queens, i, j)){
                queens[i] = j;
                dfs(queens, i+1,n, res);
                queens[i] = 0;
            }
        }
    }

    boolean isValid(int[] queens, int i, int j){
        for(int r = 0; r < i; r++){
            int c = queens[r];
            if(c == j) return false;
            if(Math.abs(c - j) == Math.abs(r - i)) return false;
        }
        return true;
    }

    List<String> build(int[] queens, int n){
        List<String> board = new ArrayList<>();
        for(int col: queens){
            StringBuilder row = new StringBuilder();
            for(int i = 0; i < n; i++) row.append(i == col ? 'Q' : '.');
            board.add(row.toString());
        }
        return board;
    }
}
