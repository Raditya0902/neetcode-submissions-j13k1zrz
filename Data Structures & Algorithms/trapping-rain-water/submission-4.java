class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int lMax = height[l], rMax = height[r];
        int water = 0;
        while(l < r){
            if(lMax <= rMax){
                l++;
                lMax = Math.max(height[l], lMax);
                water += lMax - height[l];
            }else{
                r--;
                rMax = Math.max(height[r], rMax);
                water += rMax - height[r];
            }
        }
        return water;
    }
}
