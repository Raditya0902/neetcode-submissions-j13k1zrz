class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] dist = new int[rows][cols];
        for(int[] row: dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        pq.offer(new int[]{0, 0, 0});
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int diff = curr[0], r = curr[1], c = curr[2];
            if(r == rows - 1 && c == cols - 1) return diff;
            if(dist[r][c] < diff) continue;
            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                int newDiff = Math.max(diff, Math.abs(heights[r][c] - heights[nr][nc]));
                if(newDiff < dist[nr][nc]){
                    dist[nr][nc] = newDiff;
                    pq.offer(new int[]{newDiff,nr,nc});
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}