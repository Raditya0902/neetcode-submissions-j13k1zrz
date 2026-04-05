class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int l = 0;
        HashSet<Integer> s = new HashSet<>();
        for(int r = 0; r < nums.length; r++){
            s.add(nums[r]);
            if(Math.abs(r - l) <= k && (s.size() != (r - l + 1))){
                return true;
            }
            if(Math.abs(r - l) >= k){
                s.remove(nums[l]);
                l++;
            }
        }
        return false;
    }
}