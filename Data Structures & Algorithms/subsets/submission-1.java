class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(0, nums, new ArrayList<>());
        return res;
    }

    void backtrack(int idx, int[] nums, List<Integer> ls){
        if(idx == nums.length){
            res.add(new ArrayList<>(ls));
            return;
        }
        ls.add(nums[idx]);
        backtrack(idx+1, nums, ls);
        ls.remove(ls.size() - 1);
        backtrack(idx+1, nums, ls);
    }
}
