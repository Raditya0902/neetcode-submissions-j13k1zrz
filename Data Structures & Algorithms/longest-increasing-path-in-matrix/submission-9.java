class Solution {
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] indegree = new int[m][n];

        // count neighbors that are strictly smaller (incoming edges)
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                for(int[] dir : dirs) {
                    int ni = i + dir[0], nj = j + dir[1];
                    if(ni >= 0 && ni < m && nj >= 0 && nj < n
                       && matrix[ni][nj] < matrix[i][j]) {
                        indegree[i][j]++;
                    }
                }
            }
        }

        // start BFS from cells with no smaller neighbors
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(indegree[i][j] == 0) queue.offer(new int[]{i, j});

        int pathLength = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            pathLength++;

            for(int k = 0; k < size; k++) {
                int[] cell = queue.poll();
                int i = cell[0], j = cell[1];

                for(int[] dir : dirs) {
                    int ni = i + dir[0], nj = j + dir[1];
                    if(ni >= 0 && ni < m && nj >= 0 && nj < n
                       && matrix[ni][nj] > matrix[i][j]) {
                        indegree[ni][nj]--;
                        if(indegree[ni][nj] == 0) queue.offer(new int[]{ni, nj});
                    }
                }
            }
        }

        return pathLength;
    }
}