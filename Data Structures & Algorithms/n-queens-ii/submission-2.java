class Solution {
    int[] queens;
    int n;
    int count = 0;
    public int totalNQueens(int n) {
        this.n = n;
        this.queens = new int[n];
        Arrays.fill(queens, -1);
        dfs(0);
        return count;
    }

    void dfs(int i){
        if(i == n){
            count++;
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
    
    boolean isValid(int i, int j, int[] queens){
        for(int r = 0; r < i; r++){
            int c = queens[r];
            if(c == j) return false;
            if(Math.abs(c-j) == Math.abs(r-i)) return false;
        }
        return true;
    }
}