class Solution {
    List<List<String>> res = new ArrayList<>();
    int[] queens;
    int n;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.queens = new int[n];
        Arrays.fill(queens, -1);
        dfs(0);
        return res;
    }

    void dfs(int i){
        if(i == n){
            res.add(build());
            return;
        }

        for(int j = 0; j < n; j++){
            if(isValid(i, j, queens)){
                queens[i] = j;
                dfs(i+1);
                queens[i] = -1;
            }
        }
    }

    List<String> build(){
        List<String> board = new ArrayList<>();
        for(int col: queens){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < n; i++){
                sb.append(i == col ? 'Q' : '.');
            }
            board.add(sb.toString());
        }
        return board;
    }

    boolean isValid(int i, int j, int[] queens){
        for(int r = 0; r < i; r++){
            int c = queens[r];
            if(c == j) return false;
            if(Math.abs(c-j) == Math.abs(r-i)) return false;
        }
        return true;
    }
}
