class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        boolean pick[] = new boolean[n];
        dfs(n, nums, pick);
        return res;
    }

    void dfs(int n, int[] nums, boolean[] pick){
        if(path.size() == n){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < n; i++){
            if(pick[i]) continue;
            pick[i] = true;
            path.add(nums[i]);
            dfs(n, nums, pick);
            path.remove(path.size() - 1);
            pick[i] = false;
        }
    }
}
