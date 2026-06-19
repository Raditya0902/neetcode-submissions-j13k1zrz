class Solution {
    int[] par;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        par = new int[n + 1];
        for(int i = 0; i <= n; i++) par[i] = i;

        for(int[] edge: edges){
            int rootA = find(edge[0]);
            int rootB = find(edge[1]);
            if(rootA == rootB) return edge;
            par[rootA] = rootB;
        }

        return new int[0];
    }

    int find(int x){
        if(par[x] != x) par[x] = find(par[x]);
        return par[x];
    }
}
