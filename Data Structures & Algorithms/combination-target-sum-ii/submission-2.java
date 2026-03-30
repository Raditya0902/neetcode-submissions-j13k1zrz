class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, 0, 0, target, ls, res);
        return res;
    }

    void helper(int[] candidates, int i, int sum, int target, List<Integer> ls, List<List<Integer>> res){
        if(i >= candidates.length){
            if(sum == target){
                res.add(new ArrayList<>(ls));    
            }
            return;
        }
        if(sum > target) return;

        ls.add(candidates[i]);
        helper(candidates, i + 1, sum+candidates[i], target, ls, res);
        ls.remove(ls.size() - 1);
        while(i + 1 < candidates.length && candidates[i] == candidates[i+1]){
            i++;
        }
        helper(candidates, i+1, sum, target, ls, res);
    }
}
