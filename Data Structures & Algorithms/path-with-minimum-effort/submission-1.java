class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] dist = new int[rows][cols];
        for(int[] d: dist){
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> (Integer.compare(a[0], b[0])));
        pq.offer(new int[]{0, 0, 0});
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int cost = curr[0], r = curr[1], c = curr[2];
            if(r == rows - 1 && c == cols - 1) return cost;
            if(cost > dist[r][c]) continue;
            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                int newDist = Math.max(cost, Math.abs(heights[nr][nc] - heights[r][c]));
                if(dist[nr][nc] > newDist){
                    dist[nr][nc] = newDist;
                    pq.offer(new int[]{newDist, nr, nc});
                }
            }
        }
        return -1;
    }
}