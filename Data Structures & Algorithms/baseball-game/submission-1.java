class Solution {
    public int calPoints(String[] operations) {
        int res = 0;
        Deque<Integer> st = new ArrayDeque<>();
        for(String op: operations){
            if(op.equals("+")){
                int top = st.pop();
                int newTop = st.peek() + top;
                st.push(top);
                st.push(newTop);
                res += newTop;
            }
            else if(op.equals("C")){
                res -= st.pop();
            }
            else if(op.equals("D")){
                int top = st.peek();
                st.push(2 * top);
                res += 2 * top;
            }
            else{
                st.push(Integer.parseInt(op));
                res += st.peek();
            }
        }
        return res;
    }
}