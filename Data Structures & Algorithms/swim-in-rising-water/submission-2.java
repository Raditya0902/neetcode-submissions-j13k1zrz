class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] vis = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        pq.offer(new int[]{0,0,grid[0][0]});
        vis[0][0] = true;
        int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
        int ans = 0;
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int r = curr[0], c = curr[1], t = curr[2];
            ans = Math.max(ans, t);
            if(r == n - 1 && c == n - 1) return ans;
            for(int[] dir: dirs){
                int nr = r + dir[0], nc = c + dir[1];
                if(nr >= 0 && nr < n && nc >= 0 && nc < n && !vis[nr][nc]){
                    vis[nr][nc] = true;
                    pq.offer(new int[]{nr, nc, grid[nr][nc]});
                }
            }
        }

        return ans;
    }
}
