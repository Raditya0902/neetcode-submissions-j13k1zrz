class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int lh = height[l], rh = height[r];
        int water = 0;
        while(l < r){
            if(height[l] <= height[r]){
                water += lh - height[l];
                l++;
                lh = Math.max(lh, height[l]);
            }else{
                water += rh - height[r];
                r--;
                rh = Math.max(rh, height[r]);
            }
        }
        
        return water;
    }
}
