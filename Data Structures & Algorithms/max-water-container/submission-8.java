class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1;
        int max = 0;
        while(l < r){
            int lh = heights[l];
            int rh = heights[r];
            int maxHeight = Math.min(lh, rh);
            max = Math.max(max, maxHeight * (r - l));
            if(lh <= rh){
                l++;
            }else{
                r--;
            }
        }
        return max;
    }
}
