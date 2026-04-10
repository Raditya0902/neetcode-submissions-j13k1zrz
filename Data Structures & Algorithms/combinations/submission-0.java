class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = i + 1;
        }
        backtrack(0, k, nums, new ArrayList<>());
        return res;
    }   

    void backtrack(int idx, int k, int[] nums, List<Integer> ls){
        if(ls.size() == k){
            res.add(new ArrayList<>(ls));
            return;
        }
        if(idx >= nums.length) return;

        ls.add(nums[idx]);
        backtrack(idx + 1, k, nums, ls);
        ls.remove(ls.size() - 1);
        backtrack(idx+1, k, nums, ls);
    }
}