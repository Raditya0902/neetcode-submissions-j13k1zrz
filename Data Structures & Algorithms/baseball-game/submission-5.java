class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        int sum = 0;
        for(String str: operations){
            if(str.equals("+")){
                int a = st.pop();
                int b = st.peek();
                st.push(a);
                st.push(a + b);
                sum += a + b;
            }else if(str.equals("C")){
                if(!st.isEmpty()){
                    int num = st.pop();
                    sum -= num;
                }
            }else if(str.equals("D")){
                if(!st.isEmpty()){
                    int doub = st.peek() * 2;
                    st.push(doub);
                    sum += doub;
                }
            }else{
                st.push(Integer.parseInt(str));
                sum += Integer.parseInt(str);
            }
        }
        return sum;
    }
}