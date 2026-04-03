class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] pre: prerequisites){
            adj.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        int processed = 0;
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.offer(i);
                processed++;
            }
        }

        while(!q.isEmpty()){
            int curr = q.poll();
            for(int nei: adj.get(curr)){
                indegree[nei]--;
                if(indegree[nei] == 0){
                    processed++;
                    q.offer(nei);
                }
            }
        }

        return processed == numCourses;
    }
}
