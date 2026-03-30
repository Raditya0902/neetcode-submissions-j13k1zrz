class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        helper(nums, sub, res, new boolean[nums.length]);
        return res;
    }

    void helper(int[] nums, List<Integer> sub, List<List<Integer>> res, boolean[] pick){
        if(sub.size() == nums.length){
            res.add(new ArrayList<>(sub));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(pick[i]) continue;
            pick[i] = true;
            sub.add(nums[i]);
            helper(nums, sub, res, pick);
            sub.remove(sub.size() - 1);
            pick[i] = false;
        }

    }
}
