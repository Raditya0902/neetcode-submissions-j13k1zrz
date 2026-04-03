class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length; //4
        DSU dsu = new DSU(n + 1); //0, 1, 2, 3
        for(int[] e: edges){
            int u = e[0], v = e[1];
            if(!dsu.union(u,v)) return new int[]{u,v};
        }
        return new int[0];
    }
}


class DSU{
    int[] par;
    int[] size;

    DSU(int n){
        this.par = new int[n];
        this.size = new int[n];
        for(int i = 0; i < n; i++){
            this.size[i] = 1;
            this.par[i] = i;
        }
    }

    int find(int u){
        if(par[u] == u) return u;
        return find(par[u]);
    }

    boolean union(int u, int v){
        int pu = find(u);
        int pv = find(v);

        if(pu == pv) return false;

        if(size[pu] < size[pv]){ //attach smaller tree under larger tree
            par[pu] = pv;
            size[pv] += size[pu];
        }else{
            par[pv] = pu;
            size[pu] += size[pv];
        }
        return true;
    }
}