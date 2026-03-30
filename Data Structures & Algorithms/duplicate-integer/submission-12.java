class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet set = new HashSet<>();
        for(int num: nums) set.add(num);
        return set.size() != nums.length;
    }
}