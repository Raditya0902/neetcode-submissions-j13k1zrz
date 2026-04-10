class Solution {
    List<List<Integer>> res = new ArrayList<>(); 

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(0,target,nums,new ArrayList<>());
        return res;
    }

    void backtrack(int idx, int sum, int[] nums, List<Integer> ls){
        if(idx == nums.length){
            if(sum == 0){
                res.add(new ArrayList<>(ls));
            }
            return;
        }

        if(nums[idx] <= sum){
            ls.add(nums[idx]);
            backtrack(idx, sum - nums[idx], nums, ls);
            ls.remove(ls.size() - 1);
        }

        backtrack(idx+1, sum, nums, ls);
    }
}
