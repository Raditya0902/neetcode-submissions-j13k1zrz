class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> st = new ArrayDeque<>();
        for(String t: tokens){
            if(t.equals("+")){
                int a = st.pop();
                int b = st.pop();
                st.push(a + b);
            }
            else if(t.equals("-")){
                int a = st.pop();
                int b = st.pop();
                st.push(b - a);
            }
            else if(t.equals("*")){
                int a = st.pop();
                int b = st.pop();
                st.push(a * b);
            }
            else if(t.equals("/")){
                int a = st.pop();
                int b = st.pop();
                st.push(b/a);
            }
            else{
                st.push(Integer.parseInt(t));
            }
        }
        return st.peek();
    }
}
