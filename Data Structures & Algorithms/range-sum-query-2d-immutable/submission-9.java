class NumMatrix {
    int n;
    int m;
    int[][] sMat;
    public NumMatrix(int[][] matrix) {
        this.n = matrix.length;
        this.m = matrix[0].length;
        this.sMat = new int[n+1][m+1];

        for(int i = 1; i < n + 1; i++){
            int prefix = 0;
            for(int j = 1; j < m + 1; j++){
                prefix += matrix[i-1][j-1];
                sMat[i][j] = prefix + sMat[i-1][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sMat[row2+1][col2+1] - sMat[row1][col2+1] - sMat[row2+1][col1] + sMat[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */