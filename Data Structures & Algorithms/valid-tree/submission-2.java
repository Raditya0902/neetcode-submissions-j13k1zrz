class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e: edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        HashSet<Integer> vis = new HashSet<>();

        return dfs(0,-1, vis, adj) && vis.size() == n;
    }

    boolean dfs(int node, int parent, HashSet<Integer> vis, List<List<Integer>> adj){
        if(vis.contains(node)) return false;
        vis.add(node);
        for(int nei: adj.get(node)){
            if(nei != parent){
                if(!dfs(nei, node, vis, adj)) return false;
            }
        }
        return true;
    }
}
