class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] mst = new boolean[n];
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;
        int totalCost = 0;

        for(int i = 0; i < n; i++){
            int u = -1;
            for(int v = 0; v < n; v++){
                if(!mst[v] && (u == -1 || minDist[u] > minDist[v])) u = v;
            }

            mst[u] = true;
            totalCost += minDist[u];

            for(int v = 0; v < n; v++){
                if(!mst[v]){
                    minDist[v] = Math.min(minDist[v], Math.abs(points[u][0] - points[v][0]) + Math.abs(points[u][1] - points[v][1]));
                }
            }
        }
        return totalCost;
    }
}
