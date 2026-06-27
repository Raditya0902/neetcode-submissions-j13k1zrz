class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int l = 0, r = rows * cols - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            int rowI = mid / cols;
            int colI = mid % cols;
            if(matrix[rowI][colI] == target) return true;
            else if(matrix[rowI][colI] > target) r = mid - 1;
            else l = mid + 1;
        }
        return false;
    }
}
