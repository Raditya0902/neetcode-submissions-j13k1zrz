class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int lMax = heights[0], rMax = heights[n - 1];
        int l = 0, r = n - 1;
        int max = 0;
        while(l < r){
            int minHeight = Math.min(lMax, rMax);
            int width = r - l;
            int area = minHeight * width;
            max = Math.max(area, max);
            if(lMax <= rMax){
                l++;
                lMax = Math.max(lMax, heights[l]);
            }else{
                r--;
                rMax = Math.max(rMax, heights[r]);
            }
        }
        return max;
    }
}
