class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> ls = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(0, nums.length, nums);
        return res;
    }

    void dfs(int idx, int n, int[] nums){
        res.add(new ArrayList<>(ls));
        for(int i = idx; i < n; i++){
            if(i > idx && nums[i] == nums[i-1]) continue;
            ls.add(nums[i]);
            dfs(i+1, n, nums);
            ls.remove(ls.size() - 1);
        }
    }
}
