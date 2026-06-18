class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

        for(int[] pre: prerequisites){
            int a = pre[0], b = pre[1];
            adj.get(b).add(a);
            indegree[a]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) if(indegree[i] == 0) q.offer(i);
        int processed = 0;

        while(!q.isEmpty()){
            int course = q.poll();
            processed++;
            for(int nei: adj.get(course)){
                indegree[nei]--;
                if(indegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }

        return processed == numCourses;
    }
}
