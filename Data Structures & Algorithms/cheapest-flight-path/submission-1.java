class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Edge>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] f: flights){
            adj.get(f[0]).add(new Edge(f[1], f[2]));
        }

        int[][] dist = new int[n][k+2];
        for(int[] d: dist) Arrays.fill(d, Integer.MAX_VALUE);
        dist[src][0] = 0;

        PriorityQueue<State> pq = new PriorityQueue<>((a,b)-> Integer.compare(a.cost, b.cost));
        pq.offer(new State(0,src,0));
        while(!pq.isEmpty()){
            State st = pq.poll();
            int node = st.node, cost = st.cost, stops = st.stops;
            if(node == dst) return cost;
            if(stops >= k + 1) continue;
            if(cost > dist[node][stops]) continue;
            for(Edge e: adj.get(node)){
                int v = e.node, wt = e.wt;
                int newDist = cost + wt;
                if(newDist < dist[v][stops+1]){
                    dist[v][stops + 1] = newDist;
                    pq.offer(new State(newDist , v, stops + 1));
                }
            }
        }
        return -1;
    }
}

class Edge{
    int node;
    int wt;

    Edge(int node, int wt){
        this.node = node;
        this.wt = wt;
    }
}

class State{
    int cost;
    int node;
    int stops;

    State(int cost, int node, int stops){
        this.cost = cost;
        this.node = node;
        this.stops = stops;
    }
}