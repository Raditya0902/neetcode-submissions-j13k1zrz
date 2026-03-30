class Solution {
    public boolean canFinish(int N, int[][] arr) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < N; i++) adj.add(new ArrayList<>());
        for(int[] row: arr){
            adj.get(row[1]).add(row[0]);
        }
        int[] indegree = new int[N];

        for(int i = 0; i < N; i++){
            for(int nei: adj.get(i)){
                indegree[nei]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        int processed = 0;

        for(int i = 0; i < N; i++){
            if(indegree[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()){
            int u = q.poll();
            processed++;
            for(int nei: adj.get(u)){
                indegree[nei]--;
                if(indegree[nei] == 0){
                    q.offer(nei);
                }
            }
        }

        return processed == N;
    }
}
