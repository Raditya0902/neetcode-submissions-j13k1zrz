class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
        int m = queries.length;
        int[][] sortedQueries = new int[m][2];
        for(int i = 0; i < m; i++){
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        Arrays.sort(sortedQueries, (a,b)->Integer.compare(a[0], b[0]));

        int[] ans = new int[m];
        Arrays.fill(ans, -1);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[0] != b[0]) return Integer.compare(a[0],b[0]);
            return Integer.compare(a[1], b[1]);
        });

        int i = 0;
        for(int[] q: sortedQueries){
            int query = q[0];
            int idx = q[1];

            while(i < intervals.length && intervals[i][0] <= query){
                int left = intervals[i][0];
                int right = intervals[i][1];
                int size = right - left + 1;
                pq.offer(new int[]{size, right});
                i++;
            }

            while(!pq.isEmpty() && pq.peek()[1] < query){
                pq.poll();
            }
            if(!pq.isEmpty()){
                ans[idx] = pq.peek()[0];
            }
        }

        return ans;

    }
}
