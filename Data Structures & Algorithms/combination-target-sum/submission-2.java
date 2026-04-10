class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(0, target, nums, new ArrayList<>());
        return res;
    }

    void backtrack(int i, int sum, int[] nums, List<Integer> ls){
        if(sum == 0){
            res.add(new ArrayList<>(ls));
            return;
        }
        if(i == nums.length) return;

        if(nums[i] <= sum){
            ls.add(nums[i]);
            backtrack(i, sum - nums[i], nums, ls);
            ls.remove(ls.size() - 1);
        }

        backtrack(i+1, sum, nums, ls);
    }
}
