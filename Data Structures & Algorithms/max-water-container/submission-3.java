class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1;
        int maxArea = 0;
        while(l < r){
            int maxHeight = Math.min(heights[l], heights[r]);
            int width = r - l;
            maxArea = Math.max(maxArea, width * maxHeight);
            if(heights[l] < heights[r]){
                l++;
            }else if(heights[l] >= heights[r]){
                r--;
            }
        }
        return maxArea;
    }
}
