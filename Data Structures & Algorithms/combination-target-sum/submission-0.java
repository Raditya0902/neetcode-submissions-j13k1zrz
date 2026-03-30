class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, 0, target, new ArrayList<>(), res);
        return res;
    }

    void helper(int[] nums, int i, int sum, List<Integer> sub, List<List<Integer>> res){
        if(i == nums.length){
            if(sum == 0){
                res.add(new ArrayList<>(sub));
            }
            return;
        }
        if(nums[i] <= sum){
            sub.add(nums[i]);
            helper(nums, i, sum - nums[i], sub, res);
            sub.remove(sub.size() - 1);
        }
        helper(nums, i+1, sum, sub, res);
    }
}
