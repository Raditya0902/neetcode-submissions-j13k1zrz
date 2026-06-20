class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, 0, target);
        return res;
    }

    void dfs(int[] nums, int s, int sum){
        if(sum == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = s; i < nums.length; i++){
            if(i > s && nums[i] == nums[i-1]) continue;
            if((sum - nums[i]) < 0) continue;
            path.add(nums[i]);
            dfs(nums, i+1, sum - nums[i]); //we can reuse numbers.
            path.remove(path.size() - 1);
        }
    }
}
