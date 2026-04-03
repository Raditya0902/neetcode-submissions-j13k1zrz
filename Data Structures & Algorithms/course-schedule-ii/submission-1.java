class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        int[] indegree = new int[numCourses];

        for(int[] pre: prerequisites){
            adj.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0) q.offer(i);
        }

        int[] ans = new int[numCourses];
        int index = 0, processed = 0;

        while(!q.isEmpty()){
            int u = q.poll();
            processed++;
            ans[index++] = u;
            for(int nei: adj.get(u)){
                indegree[nei]--;
                if(indegree[nei] == 0){
                    q.offer(nei);
                }
            }
        }

        return processed == numCourses ? ans : new int[0];
    }
}
