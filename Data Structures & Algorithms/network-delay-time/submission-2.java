class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n + 1; i++) adj.add(new ArrayList<>());
        for(int[] t: times){
            adj.get(t[0]).add(new Pair(t[1], t[2]));
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        pq.offer(new int[]{0, k});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int cost = curr[0], node = curr[1];
            if(cost > dist[node]) continue;
            for(Pair p: adj.get(node)){
                int wt = p.wt, nei = p.node;
                if(dist[nei] > cost + wt){
                    dist[nei] = cost + wt;
                    pq.offer(new int[]{dist[nei], nei});
                }
            }
        }
        int ans = 0;
        for(int i = 1; i < n + 1; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dist[i]);
        }
        return ans;
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