class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }

        int[] A = nums1;
        int[] B = nums2;
        int m = A.length, n = B.length;
        int total = m + n;
        int half = (total + 1) / 2;

        int left = 0, right = m;

        while(left <= right){
            int parA = left + (right - left) / 2;
            int parB = half - parA;

            int maxLeftA = (parA == 0) ? Integer.MIN_VALUE : A[parA - 1];
            int minRightA = (parA == m) ? Integer.MAX_VALUE : A[parA];

            int maxLeftB = (parB == 0) ? Integer.MIN_VALUE : B[parB - 1];
            int minRightB = (parB == n) ? Integer.MAX_VALUE : B[parB];

            if(maxLeftA <= minRightB && maxLeftB <= minRightA){
                if(total % 2 == 1) return Math.max(maxLeftA, maxLeftB);
                int leftMax = Math.max(maxLeftA, maxLeftB);
                int rightMin = Math.min(minRightA, minRightB);
                return (leftMax + rightMin)/2.0;
            }else if(maxLeftA > minRightB){
                right = parA - 1;
            }else{
                left = parA + 1;
            }
        }
        return -1.0;
    }
}
