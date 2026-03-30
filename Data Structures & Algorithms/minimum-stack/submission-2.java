class MinStack {
    Stack<Integer> st;
    Stack<Integer> minSt;
    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(minSt.isEmpty() || minSt.peek() >= val){
            minSt.push(val);
        }
    }
    
    public void pop() {
        int top = st.pop();
        if(minSt.peek() == top){
            minSt.pop();
        }
    }
    
    public int top() {
        return st.peek();   
    }
    
    public int getMin() {
        return minSt.peek();
    }
}
