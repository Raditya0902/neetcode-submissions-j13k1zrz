class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(0, nums, target, new ArrayList<>());
        return res;
    }

    void dfs(int idx, int[] nums, int target, List<Integer> ls){
        if(target == 0){
            res.add(new ArrayList<>(ls));
            return;
        }

        for(int i = idx; i < nums.length; i++){
            if(target - nums[i] < 0) continue;
            ls.add(nums[i]);
            dfs(i, nums, target - nums[i], ls);
            ls.remove(ls.size() - 1);
        }
    }

    // void dfs(int idx, int[] nums, int target, List<Integer> ls){
    //     if(target == 0){
    //         res.add(new ArrayList<>(ls));
    //         return;
    //     }

    //     for(int i = idx; i < nums.length; i++){
    //         if(target - nums[i] < 0) continue;
    //         ls.add(nums[i]);
    //         dfs(i, nums, target - nums[i], ls);
    //         ls.remove(ls.size() - 1);
    //     }
    // }
}
