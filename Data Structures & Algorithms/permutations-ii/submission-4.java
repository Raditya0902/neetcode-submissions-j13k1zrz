class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> ls = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, new boolean[nums.length]);
        return res;
    }

    void dfs(int[] nums, boolean[] vis){
        if(ls.size() == nums.length){
            res.add(new ArrayList<>(ls));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(i > 0 && !vis[i-1] && nums[i] == nums[i-1]) continue;
            if(vis[i]) continue;
            vis[i] = true;
            ls.add(nums[i]);
            dfs(nums, vis);
            vis[i] = false;
            ls.remove(ls.size() - 1);
        }
    }
}