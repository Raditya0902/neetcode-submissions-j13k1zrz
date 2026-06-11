class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int water = 0;
        int lh = height[l];
        int rh = height[r];
        while(l < r){
            if(lh <= rh){
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
