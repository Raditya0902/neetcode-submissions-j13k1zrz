class Solution {
    public int maxArea(int[] heights) {
        int i = 0, j = heights.length - 1;
        int maxArea = 0;
        while(i < j){
            int lMax = heights[i], rMax = heights[j];
            int maxHeight = Math.min(lMax, rMax);
            maxArea = Math.max(maxArea, maxHeight * (j - i));
            if(lMax <= rMax){
                i++;
            }else{
                j--;
            }
        }
        return maxArea;
    }
}
