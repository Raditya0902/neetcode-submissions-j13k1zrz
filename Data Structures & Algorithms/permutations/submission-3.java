class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, new boolean[nums.length]);
        return res;
    }

    void dfs(int[] nums, boolean[] vis){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(vis[i]) continue;
            vis[i] = true;
            path.add(nums[i]);
            dfs(nums, vis);
            vis[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
