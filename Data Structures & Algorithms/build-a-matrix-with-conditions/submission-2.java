class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[] rows = topo(k, rowConditions);
        int[] cols = topo(k, colConditions);

        if(rows == null || cols == null) return new int[0][0];
        
        int[] rowPos = new int[k+1];
        int[] colPos = new int[k+1];

        for(int i = 0; i < k; i++){
            rowPos[rows[i]] = i;
            colPos[cols[i]] = i;
        }

        int[][] matrix = new int[k][k];

        for(int v = 1; v <= k; v++){
            matrix[rowPos[v]][colPos[v]] = v;
        }

        return matrix;
    }

    int[] topo(int k, int[][] arrs){
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[k+1];
        for(int i = 0; i <= k; i++) adj.add(new ArrayList<>());
        for(int[] arr: arrs){
            adj.get(arr[0]).add(arr[1]);
            indegree[arr[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= k; i++) if(indegree[i] == 0) q.offer(i);

        int[] order = new int[k];
        int idx = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            order[idx++] = curr;
            for(int nei: adj.get(curr)){
                indegree[nei]--;
                if(indegree[nei] == 0) q.offer(nei);
            }
        }
        return idx == k ? order : null;
    }
}