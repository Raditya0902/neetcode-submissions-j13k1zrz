class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k);
        return res;
    }

    void dfs(int idx, int n, int k){
        if(k == 0){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = idx; i <= n; i++){
            path.add(i);
            dfs(i+1, n, k-1);
            path.remove(path.size() - 1);
        }
    }
}