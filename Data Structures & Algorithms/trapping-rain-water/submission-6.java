class Solution {
    public int trap(int[] height) {
        int i = 0, j = height.length - 1;
        int trappedWater = 0;
        int lh = height[i], rh = height[j];
        while(i < j){
            if(lh <= rh){
                trappedWater += lh - height[i];
                i++;
                lh = Math.max(lh, height[i]);
            }else{
                trappedWater += rh - height[j];
                j--;
                rh = Math.max(rh, height[j]);
            }
        }
        return trappedWater;
    }
}
