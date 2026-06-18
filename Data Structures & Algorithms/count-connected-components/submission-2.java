class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        boolean[] vis = new boolean[n];

        for(int[] e: edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int count = 0;

        for(int i = 0; i < n; i++){
            if(!vis[i]){
                dfs(i, adj, vis);
                count++;
            }
        }

        return count;
    }

    void dfs(int i, List<List<Integer>> adj, boolean[] vis){
        vis[i] = true;
        for(int nei: adj.get(i)){
            if(!vis[nei]){
                dfs(nei, adj, vis);
            }
        }
    }
}
