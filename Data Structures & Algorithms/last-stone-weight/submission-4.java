class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1) return stones[0];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b - a);
        for(int st: stones) pq.offer(st);
        while(pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();
            if(a == b) continue;
            else pq.offer(Math.abs(b-a));
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
