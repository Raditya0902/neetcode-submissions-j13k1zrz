class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] indegree = new int[m][n];
        int[] delR = {-1,0,1,0};
        int[] delC = {0,1,0,-1};
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < 4; k++){
                    int ni = i + delR[k];
                    int nj = j + delC[k];
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
            for(int s = 0; s < size; s++){
                int[] cell = q.poll();
                int i = cell[0]; int j = cell[1];
                for(int k = 0; k < 4; k++){
                    int ni = i + delR[k];
                    int nj = j + delC[k];

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
