class NumMatrix {

    private int[][] prefix;

    public NumMatrix(int[][] matrix) {
        this.prefix = new int[matrix.length + 1][matrix[0].length + 1];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                prefix[i+1][j+1] = prefix[i+1][j] + matrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        for(int i = 0; i < prefix.length; i++){
            for(int j = 0; j < prefix[0].length; j++){
                System.out.print(prefix[i][j] + " ");
            }
            System.out.println();
        }
        for(int i = row1+1; i <= row2+1; i++){
            res += prefix[i][col2+1] - prefix[i][col1+1-1];
        }
        return res;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */