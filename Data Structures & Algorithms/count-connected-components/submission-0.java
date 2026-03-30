class Solution {
    int total = 0;
    public int countComponents(int n, int[][] edges) {
    List<List<Integer>> adjL = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjL.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            adjL.get(edge[0]).add(edge[1]);
            adjL.get(edge[1]).add(edge[0]);
        }

        boolean[] vis = new boolean[n];

        for(int i = 0; i < n; i++){
            if(!vis[i]) {
                dfs(i, vis, adjL);
                total++;
            }
        }
        return total;
           
    }

    void dfs(int node, boolean[] vis, List<List<Integer>> adjL){
        vis[node] = true;
        for(int nei: adjL.get(node)){
            if(!vis[nei]){
                dfs(nei, vis, adjL);
            }
        }
    }
}
