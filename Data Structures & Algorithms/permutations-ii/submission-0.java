class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        backtrack(0, nums, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    void backtrack(int idx, int[] nums, List<Integer> ls, boolean[] pick){
        if(ls.size() == nums.length){
            res.add(new ArrayList<>(ls));
            return;
        }

        for(int i = 0; i < nums.length; i++){

            if(pick[i] || (i > 0 && nums[i] == nums[i-1] && !pick[i-1])) continue;
            ls.add(nums[i]);
            pick[i] = true;
            backtrack(i+1, nums, ls, pick);
            ls.remove(ls.size() - 1);
            pick[i] = false;
        }
    }
}