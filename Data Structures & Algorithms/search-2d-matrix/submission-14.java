class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int l = 0, r = n * m - 1;
        while(l <= r){
            int mid = l + (r - l)/2;
            int mr = mid / m;
            int mc = mid % m;
            if(matrix[mr][mc] == target) return true;
            else if(matrix[mr][mc] > target){
                r--;
            }else{
                l++;
            }
        }
        return false;

    }
}
