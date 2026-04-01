class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int l = 0, r = rows * cols - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            int a = mid / cols, b = mid % cols;
            if(matrix[a][b] == target) return true;
            else if(matrix[a][b] > target) r = mid - 1;
            else l = mid + 1;
        }
        return false;
    }
}
