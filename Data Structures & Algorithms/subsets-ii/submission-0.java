class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        helper(0, nums, new ArrayList<>());
        return res;
    }

    void helper(int i, int[] nums, List<Integer> sub){
        if(i == nums.length){
            res.add(new ArrayList<>(sub));
            return;
        }
        sub.add(nums[i]);
        helper(i + 1, nums, sub);
        sub.remove(sub.size() - 1);
        while(i + 1 < nums.length && nums[i] == nums[i+1]){
            i++;
        }
        helper(i+1, nums, sub);
    }
}
