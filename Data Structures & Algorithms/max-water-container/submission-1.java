class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1;
        int area = 0;
        while(l < r){
            int minHeight = Math.min(heights[l], heights[r]);
            int width = r - l;
            area = Math.max(area, minHeight * width);
            if(heights[l] <= heights[r]) l++;
            else r--;
        }
        return area;
    }
}
