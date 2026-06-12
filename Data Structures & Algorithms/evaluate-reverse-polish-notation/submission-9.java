class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int res = 0;
        for(String t: tokens){
            if(t.equals("+")){
                int a = st.pop();
                int b = st.pop();
                st.push(a + b);
            }else if(t.equals("*")){
                int a = st.pop();
                int b = st.pop();
                st.push(a*b);
            }else if(t.equals("-")){
                int a = st.pop();
                int b = st.pop();
                st.push(b - a);
            }else if(t.equals("/")){
                int a = st.pop();
                int b = st.pop();
                st.push(b/a);
            }else{
                st.push(Integer.parseInt(t));
            }
        }
        return st.peek();
    }
}
