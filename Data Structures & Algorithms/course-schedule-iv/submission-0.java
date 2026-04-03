class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] reach = new boolean[numCourses][numCourses];
        for(int[] pre: prerequisites){
            reach[pre[0]][pre[1]] = true;
        }

        for(int k = 0; k < numCourses; k++){
            for(int i = 0; i < numCourses; i++){
                for(int j = 0; j < numCourses; j++){
                    reach[i][j] = reach[i][j] || (reach[i][k] && reach[k][j]);
                }
            }
        }
        List<Boolean> ls = new ArrayList<>();
        for(int[] q: queries){
            ls.add(reach[q[0]][q[1]]);
        }
        return ls;
    }
}