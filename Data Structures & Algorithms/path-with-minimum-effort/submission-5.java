class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};

        int[][] eff = new int[m][n];
        for(int[] row: eff) Arrays.fill(row, Integer.MAX_VALUE);
        eff[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[2] - b[2]);
        pq.offer(new int[]{0,0,0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int r = curr[0], c = curr[1], e = curr[2];
            if(r == m-1 && c == n-1) return e;
            if(e > eff[r][c]) continue;

            for(int[] dir: dirs){
                int nr = r + dir[0], nc = c + dir[1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n){
                    int newEff = Math.max(e, Math.abs(heights[r][c] - heights[nr][nc]));
                    if(newEff < eff[nr][nc]){
                        eff[nr][nc] = newEff;
                        pq.offer(new int[]{nr, nc, newEff});
                    }
                }
            }
        }
        return 0;
    }
}