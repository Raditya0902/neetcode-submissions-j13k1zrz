class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        int n = nums1.length, m = nums2.length;
        int[] A = nums1, B = nums2;
        int l = 0, r = n;
        int total = n + m;
        int half = (total + 1)/2;

        while(l <= r){
            int i = l + (r - l)/2;
            int j = half - i; 

            int maxLeft1 = (i == 0) ? Integer.MIN_VALUE : nums1[i-1];
            int minRight1 = (i == n) ? Integer.MAX_VALUE : nums1[i];

            int maxLeft2 = (j == 0) ? Integer.MIN_VALUE : nums2[j-1];
            int minRight2 = (j == m) ? Integer.MAX_VALUE : nums2[j];

            if(maxLeft1 <= minRight2 && maxLeft2 <= minRight1){
                if((m + n) % 2 == 1){
                    return Math.max(maxLeft1, maxLeft2);
                }
                return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
            }else if(maxLeft1 > minRight2){
                r = i - 1;
            }else{
                l = i + 1;
            }
        }

        return -1;
    }
}
