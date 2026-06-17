class Solution {
    int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] indegree = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                for(int[] dir: dirs){
                    int ni = i + dir[0];
                    int nj = j + dir[1];
                    if(ni >= 0 && ni < m && nj >= 0 && nj < n && matrix[ni][nj] < matrix[i][j]){
                        indegree[i][j]++;
                    }
                }
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(indegree[i][j] == 0) q.offer(new int[]{i,j});
            }
        }

        int pathLength = 0;

        while(!q.isEmpty()){
            int size = q.size();
            pathLength++;
            for(int k = 0; k < size; k++){
                int[] cell = q.poll();
                int i = cell[0], j = cell[1];
                for(int[] dir: dirs){
                    int ni = i + dir[0];
                    int nj = j + dir[1];
                    if(ni >= 0 && ni < m && nj >= 0 && nj < n && matrix[ni][nj] > matrix[i][j]){
                        indegree[ni][nj]--;
                        if(indegree[ni][nj] == 0) q.offer(new int[]{ni,nj});
                    }
                }
            }
        }
        return pathLength;
    }
}
