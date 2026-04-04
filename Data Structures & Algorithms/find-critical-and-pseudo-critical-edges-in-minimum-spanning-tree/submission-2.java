class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cri = new ArrayList<>();
        List<Integer> pse = new ArrayList<>();

        List<int[]> edgeList = new ArrayList<>();
        for(int i = 0; i < edges.length; i++){
            edgeList.add(new int[]{edges[i][0], edges[i][1], edges[i][2], i});
        }
        edgeList.sort((a,b)->Integer.compare(a[2], b[2]));
        DSU dsu = new DSU(n);
        int mst = 0;
        for(int[] edge: edgeList){
            if(dsu.union(edge[0], edge[1])){
                mst+=edge[2];
            }
        }

        for(int[] edge: edgeList){
            DSU dsuWithout = new DSU(n);
            int mstWithout = 0;
            int edgesWithout = 0;
            for(int[] other: edgeList){
                if(other[3] == edge[3]) continue;
                if(dsuWithout.union(other[0], other[1])){
                    mstWithout += other[2];
                    edgesWithout++;
                }
            }
            if(edgesWithout != n - 1 || mstWithout > mst){
                cri.add(edge[3]);
                continue;
            }

            DSU dsuWith = new DSU(n);
            int mstWith = edge[2];
            int edgesWith = 1;
            dsuWith.union(edge[0], edge[1]);

            for(int[] other: edgeList){
                if(other[3] == edge[3]) continue;
                if(dsuWith.union(other[0], other[1])){
                    mstWith += other[2];
                    edgesWith++;
                }
            }
            if(edgesWith == n - 1 && mstWith == mst){
                pse.add(edge[3]);
            }
        }

        ans.add(cri);
        ans.add(pse);
        return ans;
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
        if(x != par[x]){
            par[x] = find(par[x]);
        }
        return par[x];
    } 
    boolean union(int u, int v){ 
        int pu = find(u), pv = find(v); 
        if(pu == pv) return false; 
        if(size[pu] <= size[pv]){ 
            par[pu] = pv; 
            size[pv] += size[pu]; 
        }
        else{ 
            par[pv] = pu; 
            size[pu] += size[pv]; 
        } 
        return true; 
    }
}