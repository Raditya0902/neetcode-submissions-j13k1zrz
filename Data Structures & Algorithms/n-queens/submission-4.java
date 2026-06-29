class Solution {
    List<List<String>> res = new ArrayList<>();
    int n;
    int[] queens;
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.queens = new int[n];
        Arrays.fill(queens, -1);
        
        dfs(0);

        return res;
    }

    void dfs(int i){
        if(i == n){
            res.add(build(queens));
            return;
        }

        for(int j = 0; j < n; j++){
            if(isValid(queens, i, j)){
                queens[i] = j;
                dfs(i+1);
                queens[i] = -1;
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

    List<String> build(int[] queens){
        List<String> board = new ArrayList<>();
        for(int col: queens){
            StringBuilder row = new StringBuilder();
            for(int i = 0; i < n; i++){
                row.append(i == col ? 'Q' : '.');
            }
            board.add(row.toString());
        }
        return board;
    }
}
