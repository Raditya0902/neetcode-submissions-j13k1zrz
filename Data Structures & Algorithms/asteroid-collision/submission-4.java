class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int a: asteroids){
            boolean destroyed = false;
            while(!st.isEmpty() && st.peek() > 0 && a < 0){
                int top = st.peek();
                if(top == -a){
                    st.pop();
                    destroyed = true;
                    break;
                }else if(top > -a){
                    destroyed = true;
                    break;
                }else{
                    st.pop();
                    continue;                    
                }
            }

            if(!destroyed) st.push(a);
        }

        int[] ans = new int[st.size()];
        for(int i = st.size() - 1; i >= 0; i--){
            ans[i] = st.pop();
        }

        return ans;
    }
}