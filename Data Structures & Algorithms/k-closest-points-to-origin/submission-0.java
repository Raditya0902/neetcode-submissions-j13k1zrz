class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a->a[0]));
        for(int[] point: points){
            int x = point[0], y = point[1];
            int dist = x*x + y*y;
            pq.add(new int[]{dist, x, y});
        }
        for(int i = 0; i < k; i++){
            int[] point = pq.poll();
            ans[i][0] = point[1];
            ans[i][1] = point[2];
        }
        return ans;
    }
}
