class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0] - b[0]);
        Arrays.sort(trips, (a,b)-> a[1] - b[1]);
        int current = 0;
        for(int[] t: trips){
            int pickup = t[1];
            while(!pq.isEmpty() && pq.peek()[0] <= pickup){
                current -= pq.poll()[1];
            }
            current += t[0];
            if(current > capacity) return false;
            pq.offer(new int[]{t[2], t[0]});
        }
        return true;
    }
}