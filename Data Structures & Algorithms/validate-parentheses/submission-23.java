class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch: s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '[') st.push(ch);
            else{
                if(st.isEmpty()) return false;
                char top = st.peek();
                if((top == '(' && ch != ')')
                  || (top == '{' && ch != '}')
                  || (top == '[' && ch != ']')) return false;
                st.pop();
            }
        }
        return st.isEmpty() ? true : false;
    }
}
