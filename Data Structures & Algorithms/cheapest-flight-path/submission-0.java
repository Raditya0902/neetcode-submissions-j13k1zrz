class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Edge>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] f: flights) adj.get(f[0]).add(new Edge(f[1],f[2]));
        int[][] best = new int[n][k+2];
        for(int[] row: best) Arrays.fill(row, Integer.MAX_VALUE);
        best[src][0] = 0;

        PriorityQueue<State> pq = new PriorityQueue<>((a,b)-> (Integer.compare(a.costSoFar, b.costSoFar)));
        pq.offer(new State(0,src,0));

        while(!pq.isEmpty()){
            State curr = pq.poll();
            int costSoFar = curr.costSoFar, node = curr.node, stopsUsed = curr.stopsUsed;
            if(node == dst) return costSoFar;
            if(stopsUsed == k + 1) continue;
            for(Edge edge: adj.get(node)){
                int v = edge.node, wt = edge.wt;
                int newDist = costSoFar + wt;
                if(best[v][stopsUsed + 1] > newDist){
                    best[v][stopsUsed + 1] = newDist;
                    pq.offer(new State(newDist, v, stopsUsed + 1));
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
    int costSoFar;
    int node;
    int stopsUsed;

    State(int costSoFar, int node, int stopsUsed){
        this.costSoFar = costSoFar;
        this.node = node;
        this.stopsUsed = stopsUsed;
    }
}
