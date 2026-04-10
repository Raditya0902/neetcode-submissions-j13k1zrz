class Solution {
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        helper(0, nums, new ArrayList<>());
        return res;
    }

    void helper(int idx, int[] nums, List<Integer> ls){
        if(idx == nums.length){
            res.add(new ArrayList<>(ls));
            return;
        }

        ls.add(nums[idx]);
        helper(idx+1, nums, ls);
        ls.remove(ls.size() - 1);
        while(idx + 1 < nums.length && nums[idx] == nums[idx + 1]){
            idx++;
        }
        helper(idx + 1, nums, ls);
    }

}
