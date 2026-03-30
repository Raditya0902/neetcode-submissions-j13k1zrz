class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), res);
        return res;
    }

    void dfs(int[] nums, int i, List<Integer> sub, List<List<Integer>> res){
        if(i >= nums.length) {
            res.add(new ArrayList<>(sub));
            return;
        }
        sub.add(nums[i]);
        dfs(nums, i+1, sub, res);
        sub.remove(sub.size() - 1);
        dfs(nums, i+1, sub, res);
    }
}
