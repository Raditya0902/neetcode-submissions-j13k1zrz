class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[] row = topoSort(k, rowConditions);
        if(row.length != k) return new int[0][0];
        int[] col = topoSort(k, colConditions);
        if(col.length != k) return new int[0][0];

        int[][] res = new int[k][k];
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < row.length; i++){
            map.computeIfAbsent(row[i], x-> new ArrayList<>()).add(i);
        }
        for(int i = 0; i < col.length; i++){
            map.computeIfAbsent(col[i], x-> new ArrayList<>()).add(i);
        }

        for(int key: map.keySet()){
            List<Integer> ls = map.get(key);
            int r = ls.get(0), c = ls.get(1);
            res[r][c] = key;
        }
        return res;
    }

    int[] topoSort(int k, int[][] edges){
        int[]indegree = new int[k + 1];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= k; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] e: edges){
            adj.get(e[0]).add(e[1]);
            indegree[e[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i<= k; i++){
            if(indegree[i] == 0) q.offer(i);
        }

        int[] order = new int[k];
        int idx = 0;
        while(!q.isEmpty()){
            int u = q.poll();
            order[idx++] = u;
            for(int nei: adj.get(u)){
                indegree[nei]--;
                if(indegree[nei] == 0) q.offer(nei);
            }
        }

        if(idx != k) return new int[0];
        return order;
    }
}