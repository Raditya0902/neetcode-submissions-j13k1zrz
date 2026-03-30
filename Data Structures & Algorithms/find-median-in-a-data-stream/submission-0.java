class MedianFinder {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        minHeap.offer(num);
        if(minHeap.size() - maxHeap.size() > 1 || !maxHeap.isEmpty() && minHeap.peek() > maxHeap.peek()){
            maxHeap.offer(minHeap.poll());
        }
        
        if(maxHeap.size() - minHeap.size() > 1){
            minHeap.offer(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        if((minHeap.size() == maxHeap.size())){
            return (minHeap.peek() + maxHeap.peek())/2.0;
        }
        else{
            if(minHeap.size() > maxHeap.size()){
                return (double)minHeap.peek();
            }else{
                return (double)maxHeap.peek();
            }
        }
    }
}
