class MinStack {
    Stack<Integer> st;
    Stack<Integer> minStack;
    public MinStack() {
        st = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            st.push(val);
            minStack.push(val);
        }
        else{
            st.push(val);
            if(minStack.peek() > val){
                minStack.push(val);
            }else{
                minStack.push(minStack.peek());
            }
        }
    }
    
    public void pop() {
        if(st.isEmpty()) return;
        st.pop();
        minStack.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
