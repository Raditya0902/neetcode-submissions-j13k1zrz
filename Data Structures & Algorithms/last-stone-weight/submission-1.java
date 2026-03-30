class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int num: stones){
            maxHeap.offer(num);
        }
        while(maxHeap.size() >= 2){
            int a = maxHeap.poll(), b = maxHeap.poll();
            if(a == b) continue;
            if(a < b || a > b) maxHeap.offer(Math.abs(a - b));
        }
        return maxHeap.peek() == null ? 0 : maxHeap.peek();
    }
}
