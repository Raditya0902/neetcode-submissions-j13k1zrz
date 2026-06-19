class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1) return new ArrayList<>(List.of(0));
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        int[] degree = new int[n];
        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(degree[i] == 1) q.offer(i);
        }

        int rem = n;

        while(rem > 2){
            int leafCount = q.size();
            rem -= leafCount;
            for(int i = 0; i < leafCount; i++){
                int leaf = q.poll();
                for(int nei: adj.get(leaf)){
                    degree[nei]--;
                    if(degree[nei] == 1) q.offer(nei);
                }
            }
        }
        return new ArrayList<>(q);
    }

}