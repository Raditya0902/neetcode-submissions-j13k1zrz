class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums, new ArrayList<>());
        return res;
    }

    void dfs(int idx, int[] nums, List<Integer> path){
        res.add(new ArrayList<>(path));
        for(int i = idx; i < nums.length; i++){
            path.add(nums[i]);
            dfs(i+1,nums, path);
            path.remove(path.size() - 1);
        }
    }
}
