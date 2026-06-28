class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        int n = nums1.length;
        int m = nums2.length;
        int[] A = nums1;
        int[] B = nums2;

        int l = 0, r = n;
        int total = n + m;
        int half = (total + 1) / 2;
        while(l <= r){
            int parA = l + (r - l)/2;
            int parB = half - parA;

            int ALeft = parA == 0 ? Integer.MIN_VALUE : A[parA - 1];
            int BLeft = parB == 0 ? Integer.MIN_VALUE : B[parB - 1];
            int ARight = parA == n ? Integer.MAX_VALUE : A[parA];
            int BRight = parB == m ? Integer.MAX_VALUE : B[parB];

            if(ALeft <= BRight && BLeft <= ARight){
                if(total % 2 == 1){
                    return Math.max(ALeft, BLeft);
                }else{
                    return (Math.max(ALeft, BLeft) + Math.min(ARight, BRight)) / 2.0;
                }
            }else if(ALeft > BRight){
                r = parA - 1;
            }else{
                l = parA + 1;
            }
        }
        return -1;
    }
}
