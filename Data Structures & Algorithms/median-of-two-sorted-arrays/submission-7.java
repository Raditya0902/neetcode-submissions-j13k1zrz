class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if(n > m) return findMedianSortedArrays(nums2, nums1);
        int[] A = nums1;
        int[] B = nums2;
        int l = 0, r = n;
        int total = n + m;
        int half = (total + 1) / 2;
        while(l <= r){
            int parA = l + (r - l) / 2;
            int parB = half - parA;
            int Aleft = (parA == 0) ? Integer.MIN_VALUE : A[parA - 1];
            int Aright = (parA == n) ? Integer.MAX_VALUE : A[parA];
            int Bleft = (parB == 0) ? Integer.MIN_VALUE : B[parB - 1];
            int Bright = (parB == m) ? Integer.MAX_VALUE : B[parB];
            
            if(Aleft <= Bright && Aright >= Bleft){
                if(total % 2 == 1) return Math.max(Aleft, Bleft);
                else{
                    int max = Math.max(Aleft, Bleft);
                    int min = Math.min(Aright, Bright);
                    return (max + min) / 2.0;
                }
            }
            else if(Aleft > Bright){
                r = parA - 1;
            }else{
                l = parA + 1;
            }
        }
        return -1;
    }
}
