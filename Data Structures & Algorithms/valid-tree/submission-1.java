class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n == 0) return true;
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] vis = new boolean[n];
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int parent= -1;
        boolean v1 = dfs(0,adj,vis,-1);
        boolean v2 = true;
        for(int i = 0; i < n; i++){
            if(!vis[i]) v2 = false;
        }
        return v1 && v2;        
    }

    boolean dfs(int node, List<List<Integer>> adj, boolean[] vis, int parent){
        if(vis[node]) return false;
        vis[node] = true;
        for(int nei: adj.get(node)){
            if(nei != parent){
                if(!dfs(nei, adj, vis, node)) return false;
            }
        }
        return true;
    }
}
