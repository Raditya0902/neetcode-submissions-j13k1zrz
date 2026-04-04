class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        DSU dsu = new DSU(n);

        List<int[]> edges = new ArrayList<>();

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[]{dist, i, j});
            }
        }
        edges.sort((a,b)->Integer.compare(a[0], b[0]));
        int res = 0;
        for(int[] e: edges){
            if(dsu.union(e[1], e[2])){
                res += e[0];
            }
        }
        return res;
    }
}

class DSU{
    int[] par;
    int[] size;

    DSU(int n){
        this.par = new int[n];
        this.size = new int[n];

        for(int i = 0; i < n; i++){
            par[i] = i;
            size[i] = 1;
        } 
    }

    int find(int x){
        if(x == par[x]) return x;
        return find(par[x]);
    }

    boolean union(int u, int v){
        int pu = find(u), pv = find(v);
        if(pu == pv) return false;
        if(size[pu] <= size[pv]){
            par[pu] = pv;
            size[pv] += size[pu];
        }else{
            par[pv] = pu;
            size[pu] += size[pv];
        }
        return true;
    }
}