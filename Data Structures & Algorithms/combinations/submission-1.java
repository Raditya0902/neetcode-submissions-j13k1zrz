class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(n, k, 1);
        return res;
    }

    void dfs(int n, int k, int s){
        if(k == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = s; i <= n; i++){
            path.add(i);
            dfs(n, k-1, i+1);
            path.remove(path.size() - 1);
        }
    }
}