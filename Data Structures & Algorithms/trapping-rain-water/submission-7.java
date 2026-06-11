class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int trappedWater = 0;
        int lh = height[l], rh = height[r];
        while(l < r){
            if(lh <= rh){
                trappedWater += lh - height[l];
                l++;
                lh = Math.max(lh, height[l]);
            }else{
                trappedWater += rh - height[r];
                r--;
                rh = Math.max(rh, height[r]);
            }
        }
        return trappedWater;
    }

}
