class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;
        DisjointSet dsu = new DisjointSet(n + 1);
        for(int[] edge: edges){
            int u = edge[0], v = edge[1];
            if(dsu.find(u,v)) return new int[]{u,v};
            else dsu.unionBySize(u,v);
        }
        return new int[0];
    }
}


class DisjointSet {
    int[] parent;
    int[] size;

    public DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];
        
        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    int findParent(int x){
        if(parent[x] == x) return x;
        parent[x] = findParent(parent[x]);
        return parent[x];
    }


    public boolean find(int u, int v) {
        return findParent(u) == findParent(v);
    }

    public void unionBySize(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);
        if(pu == pv) return;

        if(size[pu] < size[pv]){
            parent[pu] = pv;
            size[pv] += size[pu];
        }else{
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }
}

