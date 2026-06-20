class Solution {
    int[] par;
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int m = edges.length;
        Integer[] idx = new Integer[m];
        for(int i = 0; i < m; i++) idx[i] = i;
        Arrays.sort(idx, (a,b)-> edges[a][2] - edges[b][2]);
        
        int baseWeight = buildMST(n, edges, idx, -1, -1); // normal MST, no constraints

        List<Integer> cri = new ArrayList<>();
        List<Integer> pse = new ArrayList<>();

        for(int i = 0; i < m; i++){
            int weiExclu = buildMST(n, edges, idx, -1, i);
            if(weiExclu > baseWeight || weiExclu == -1) {
                cri.add(i);
                continue;
            }

            int weiInclu = buildMST(n, edges, idx, i, -1);
            if(weiInclu == baseWeight){
                pse.add(i);
            }
        }
        return List.of(cri, pse);
    }

    int find(int x){
        if(par[x] != x) par[x] = find(par[x]);
        return par[x];
    }

    int buildMST(int n, int[][] edges, Integer[] idx, int fI, int ex){
        this.par = new int[n];
        for(int i = 0; i < n; i++) par[i] = i;
        int wei = 0, count = 0;
        if(fI != -1){
            union(edges[fI][0], edges[fI][1]);
            wei += edges[fI][2];
            count++;
        }

        for(int i: idx){
            if(i == ex || i == fI) continue;
            int u = edges[i][0], v = edges[i][1], w = edges[i][2];
            if(find(u) != find(v)){
                union(u, v);
                wei += w;
                count++;
            }
        }
        return count == n - 1 ? wei : -1;
    }

    void union(int a, int b){
        par[find(a)] = find(b);
    }
}