class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums, new ArrayList<>());
        return res;
    }

    void dfs(int idx, int[] nums, List<Integer> ls){
        res.add(new ArrayList<>(ls));
        for(int i = idx; i < nums.length; i++){
            ls.add(nums[i]);
            dfs(i+1, nums, ls);
            ls.remove(ls.size() - 1);
        }
    }
}
