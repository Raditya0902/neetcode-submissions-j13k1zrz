class MyQueue {
    Deque<Integer> inSt;
    Deque<Integer> outSt;
    public MyQueue() {
        inSt = new ArrayDeque<>();
        outSt = new ArrayDeque<>();
    }
    
    public void push(int x) {
        inSt.push(x);
    }
    
    public int pop() {
        moveIfneeded();
        return outSt.pop();
    }
    
    public int peek() {
        moveIfneeded();
        return outSt.peek();
    }
    
    public boolean empty() {
        return inSt.isEmpty() && outSt.isEmpty();
    }

    private void moveIfneeded(){
        if(outSt.isEmpty()){
            while(!inSt.isEmpty()){
                outSt.push(inSt.pop());
            }
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */