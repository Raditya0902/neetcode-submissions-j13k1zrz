class Solution {
    public int calPoints(String[] operations) {
        int ans = 0;
        Stack<Integer> st = new Stack<>();
        for(String op: operations){
            if(op.equals("+")){
                int top = st.pop();
                int newTop = st.peek() + top;
                st.push(top);
                st.push(newTop);
                ans += newTop;
            }else if(op.equals("C")){
                ans -= st.pop();
            }else if(op.equals("D")){
                st.push(2 * st.peek());
                ans += st.peek();
            }else{
                st.push(Integer.parseInt(op));
                ans += st.peek();
            }
        }

        return ans;
    }
}