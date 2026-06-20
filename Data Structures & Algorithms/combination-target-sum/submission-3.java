class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(nums, 0, target);
        return res;
    }

    void dfs(int[] nums, int s, int sum){
        if(sum == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = s; i < nums.length; i++){
            if((sum - nums[i]) < 0) continue;
            path.add(nums[i]);
            dfs(nums, i, sum - nums[i]);
            path.remove(path.size() - 1);
        }
    }
}
