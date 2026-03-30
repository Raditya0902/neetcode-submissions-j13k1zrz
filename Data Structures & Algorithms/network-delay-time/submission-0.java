class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n + 1; i++) adj.add(new ArrayList<>());
        for(int[] e: times) adj.get(e[0]).add(new Pair(e[1], e[2]));
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<int[]> pq =new PriorityQueue<>((a,b)->(Integer.compare(a[0],b[0])));
        pq.offer(new int[]{0, k});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int d = curr[0], u = curr[1];
            if(d != dist[u]) continue;
            for(Pair edge: adj.get(u)){
                int v = edge.node, wt = edge.wt;
                if(dist[v] > dist[u] + wt){
                    dist[v] = dist[u] + wt;
                    pq.offer(new int[]{dist[v], v});
                }
            }
        }

        int max = 0;
        for(int i = 1; i <= n; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(dist[i], max);
        }
        return max;
    }
}

class Pair{
    int node;
    int wt;

    Pair(int node, int wt){
        this.node = node;
        this.wt = wt;
    }
}
