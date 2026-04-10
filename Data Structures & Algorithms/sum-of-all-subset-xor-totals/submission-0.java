class Solution {
    int res = 0;
    public int subsetXORSum(int[] nums) {
        backtrack(nums, 0, new ArrayList<>());
        return res;
    }

    void backtrack(int[] nums, int i, List<Integer> ls){
        int xor = 0;
        for(int n: ls) xor ^= n;
        res += xor;

        for(int j = i; j < nums.length; j++){
            ls.add(nums[j]);
            backtrack(nums, j + 1, ls);
            ls.remove(ls.size() - 1);
        }
    }
}