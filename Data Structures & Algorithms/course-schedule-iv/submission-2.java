class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> ls = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        boolean[][] reachable = new boolean[numCourses][numCourses];
        int[] indegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pre: prerequisites){
            int a = pre[0], b = pre[1];
            adj.get(a).add(b);
            indegree[b]++;
            reachable[a][b] = true;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()){
            int curr = q.poll();
            for(int nei: adj.get(curr)){
                for(int k = 0; k < numCourses; k++){
                    if(reachable[k][curr]) reachable[k][nei] = true;
                }
                indegree[nei]--;
                if(indegree[nei] == 0) q.offer(nei);
            }
        }

        for(int[] qu: queries){
            int a = qu[0], b = qu[1];
            if(reachable[a][b]) ls.add(true);
            else ls.add(false);
        }   
        return ls;
    }
}