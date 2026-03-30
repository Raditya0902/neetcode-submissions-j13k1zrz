class Solution {
    public int calPoints(String[] operations) {
        int res = 0;
        Stack<Integer> st = new Stack<>();
        for(String s: operations){
            if(s.equals("+")){
                int top = st.pop();
                int newTop = top + st.peek();
                st.push(top);
                st.push(newTop);
                res += newTop;
            }else if(s.equals("D")){
                int top = st.peek();
                st.push(2 * top);
                res += st.peek();
            }else if(s.equals("C")){
                res -= st.pop();
            }else{
                st.push(Integer.parseInt(s));
                res += st.peek();
            }
        }
        return res;
    }
}