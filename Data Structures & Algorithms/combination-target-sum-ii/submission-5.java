class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(0, candidates, target, new ArrayList<>());
        return res;
    }

    void dfs(int idx, int[] nums, int target, List<Integer> ls){
        if(target == 0){
            res.add(new ArrayList<>(ls));
            return;
        }

        for(int i = idx; i < nums.length; i++){
            if(i > idx && nums[i] == nums[i-1]) continue;
            if(target - nums[i] < 0) continue;
            ls.add(nums[i]);
            dfs(i+1, nums, target - nums[i], ls);
            ls.remove(ls.size() - 1);
        }
    }
}
