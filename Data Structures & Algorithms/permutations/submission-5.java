class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> ls = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean vis[] = new boolean[nums.length];
        dfs(nums, vis);
        return res;
    }

    void dfs(int[] nums, boolean[] vis){
        if(ls.size() == nums.length){
            res.add(new ArrayList<>(ls));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(vis[i]) continue;
            vis[i] = true;
            ls.add(nums[i]);
            dfs(nums, vis);
            ls.remove(ls.size() - 1);
            vis[i] = false;
        }
    }
}
