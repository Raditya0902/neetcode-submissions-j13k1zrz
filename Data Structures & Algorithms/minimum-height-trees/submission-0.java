// good question
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ls = new ArrayList<>();
        if(n == 1) {
            ls.add(0);
            return ls;
        }

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        int[] degree = new int[n];

        for(int[] e: edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
            degree[e[0]]++;
            degree[e[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(degree[i] == 1) q.offer(i);
        }

        int remaining = n;

        while(remaining > 2){
            int size = q.size();
            remaining -= size;
            for(int i = 0; i < size; i++){
                int node = q.poll();
                for(int nei: adj.get(node)){
                    degree[nei]--;
                    if(degree[nei] == 1) q.offer(nei);
                }
            }
        }

        while(!q.isEmpty()){
            ls.add(q.poll());
        }
        return ls;
    }
}