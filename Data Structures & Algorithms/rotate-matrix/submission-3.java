class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < m; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i = 0; i < n; i++){
            reverse(matrix[i]);
        }
    }

    void reverse(int[] arr){
        int i = 0, j = arr.length - 1;
        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++; j--;
        }
    }
}
