class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        for(String str: operations){
            if(str.equals("+")){
                int a = st.pop();
                int b = st.peek();
                st.push(a);
                st.push(a + b);
                ans += a + b;
            }else if(str.equals("C")){
                int a = st.pop();
                ans -= a;
            }else if(str.equals("D")){
                int a = st.peek();
                st.push(a * 2);
                ans += a * 2;
            }else{
                int num = Integer.parseInt(str);
                st.push(num);
                ans += num;
            }
        }
        return ans;
        
    }
}