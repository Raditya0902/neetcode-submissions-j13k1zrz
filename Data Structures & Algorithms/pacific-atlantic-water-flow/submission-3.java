class Solution {
    int[][] dirs = {{-1,0}, {0,1}, {1,0} ,{0,-1}};
    int m, n;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];
        
        Queue<int[]> pacQ = new LinkedList<>();
        Queue<int[]> atlQ = new LinkedList<>();

        for(int i = 0; i < m; i++){
            pacQ.offer(new int[]{i,0});
            atlQ.offer(new int[]{i, n-1});
            pac[i][0] = true;
            atl[i][n-1] = true;
        }

        for(int j = 0; j < n; j++){
            pacQ.offer(new int[]{0, j});
            atlQ.offer(new int[]{m-1,j});
            pac[0][j] = true;
            atl[m-1][j] = true;
        }

        bfs(heights, pacQ, pac);
        bfs(heights, atlQ, atl);

        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(pac[i][j] && atl[i][j]) res.add(Arrays.asList(i,j));
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
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && !vis[nr][nc] && heights[nr][nc] >= heights[r][c]){
                    vis[nr][nc] = true;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
    }
}
