class MinStack {
    Stack<Integer> st;
    Stack<Integer> minSt;
    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(minSt.isEmpty() || (!minSt.isEmpty() && val <= minSt.peek())) minSt.push(val);
    }
    
    public void pop() {
        if(st.isEmpty()) return;
        int top = st.pop();
        if(!minSt.isEmpty() && minSt.peek() == top) minSt.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return !minSt.isEmpty() ? minSt.peek() : Integer.MAX_VALUE;
    }
}
