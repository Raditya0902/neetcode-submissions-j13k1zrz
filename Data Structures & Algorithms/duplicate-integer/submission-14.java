class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int n: nums) set.add(n);
        return set.size() != nums.length;
    }
}