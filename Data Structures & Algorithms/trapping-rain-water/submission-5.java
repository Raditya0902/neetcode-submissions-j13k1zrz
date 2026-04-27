class Solution {
    public int trap(int[] height) {
        int water = 0;
        int l = 0, r = height.length - 1;
        int lMax = height[l], rMax = height[r];
        while(l < r){
            if(lMax <= rMax){
                l++;
                lMax = Math.max(lMax, height[l]);
                water += lMax - height[l];
            }else{
                r--;
                rMax = Math.max(rMax, height[r]);
                water += rMax - height[r];
            }
        }
        return water;
    }
}
