class Solution {
    int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
    int m, n;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.n = heights.length;
        this.m = heights[0].length;
        boolean[][] pac = new boolean[n][m];
        boolean[][] atl = new boolean[n][m];

        Queue<int[]> pq = new LinkedList<>();
        Queue<int[]> aq = new LinkedList<>();

        for(int i = 0; i < n; i++){
            pq.offer(new int[]{i, 0});
            aq.offer(new int[]{i, m-1});
            pac[i][0] = true;
            atl[i][m-1] = true;
        }

        for(int j = 0; j < m; j++){
            aq.offer(new int[]{n-1,j});
            pq.offer(new int[]{0,j});
            atl[n-1][j] = true;
            pac[0][j] = true;
        }

        bfs(heights, pq, pac);
        bfs(heights, aq, atl);

        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(pac[i][j] && atl[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }

    void bfs(int[][] heights, Queue<int[]> q, boolean[][] vis){
        while(!q.isEmpty()){
            int[] cell = q.poll();
            int r = cell[0], c = cell[1];
            for(int[] dir: dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc] && heights[nr][nc] >= heights[r][c]){
                    vis[nr][nc] = true;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
    }
}
