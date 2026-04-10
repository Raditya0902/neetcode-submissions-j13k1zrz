class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(0, 0, target, candidates, new ArrayList<>());
        return res;
    }

    void backtrack(int i, int sum, int target, int[] candidates, List<Integer> ls){
        if(sum == target){
            res.add(new ArrayList<>(ls));
            return;
        }
        
        if(i >= candidates.length){
            return;
        }

        if(sum > target) return;

        ls.add(candidates[i]);
        backtrack(i + 1, sum + candidates[i], target, candidates, ls);
        ls.remove(ls.size() - 1);
        while(i + 1 < candidates.length && candidates[i] == candidates[i+1]){
            i++;
        }
        backtrack(i+1, sum, target, candidates, ls);
    }
}
