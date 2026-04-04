class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] vis = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        pq.offer(new int[]{grid[0][0], 0, 0});
        vis[0][0] = true;
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int t = curr[0], r = curr[1], c = curr[2];
            if(r == n - 1 && c == n - 1) return t;
            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr < 0 || nr >= n || nc < 0 || nc >= n || vis[nr][nc]) continue;
                vis[nr][nc] = true;
                pq.offer(new int[]{Math.max(t, grid[nr][nc]), nr, nc});
            }
        }
        return 0;
    
    }
}
