class Solution {
    int res = 0;
    public int subsetXORSum(int[] nums) {
        backtrack(0, nums, new ArrayList<>());
        return res;
    }

    void backtrack(int ind, int[] nums, List<Integer> ls){
        int xor = 0;
        for(int n: ls){
            xor ^= n;
        }
        res += xor;

        for(int j = ind; j < nums.length; j++){
            ls.add(nums[j]);
            backtrack(j+1, nums, ls);
            ls.remove(ls.size() - 1);
        }
    }
}