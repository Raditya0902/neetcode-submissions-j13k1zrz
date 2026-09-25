class Solution {
    public void setZeroes(int[][] matrix) {
        int x = 0, y = 0;
        int n = matrix.length, m = matrix[0].length;

        for(int i = 0; i < n; i++){
            if(matrix[i][0] == 0){
                x = 1;
            }
        }

        for(int j = 0; j < m; j++){
            if(matrix[0][j] == 0){
                y = 1;
            }
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int j = 1; j < m; j++){
            for(int i = 0; i < n; i++){
                if(matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(x == 1){
            for(int i = 0; i < n; i++){
                matrix[i][0] = 0;
            }
        }

        if(y == 1){
            for(int j = 0; j < m; j++){
                matrix[0][j] = 0;
            }
        }

    }
}
