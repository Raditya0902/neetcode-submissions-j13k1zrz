class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        List<int[]> edgeList = new ArrayList<>();
        for(int i = 0; i < edges.length; i++){
            edgeList.add(new int[]{edges[i][0], edges[i][1], edges[i][2], i});
        }
        edgeList.sort((a,b)->Integer.compare(a[2], b[2]));
        int mstW = 0;
        DSU dsu = new DSU(n);
        for(int[] e: edgeList){
            if(dsu.union(e[0], e[1])){
                mstW += e[2];
            }
        }

        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudo = new ArrayList<>();
        for(int[] edge: edgeList){
            DSU dsuWithout = new DSU(n);
            int weight = 0;
            int edgesWithout = 0;
            for(int[] other: edgeList){
                if(other[3] != edge[3] && dsuWithout.union(other[0], other[1])){
                    weight += other[2];
                    edgesWithout++;
                }
            }

            if(edgesWithout != n - 1 || weight > mstW){
                critical.add(edge[3]);
                continue;
            }
            
            DSU dsuWith = new DSU(n);
            int weightUsed = edge[2];
            int edgesUsed = 1;
            dsuWith.union(edge[0], edge[1]);

            for(int[] other: edgeList){
                if(other[3] == edge[3]) continue;
                if(dsuWith.union(other[0], other[1])){
                    weightUsed += other[2];
                    edgesUsed++;
                }
            }

            if(edgesUsed == n - 1 && weightUsed == mstW){
                pseudo.add(edge[3]);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(critical);
        ans.add(pseudo);
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