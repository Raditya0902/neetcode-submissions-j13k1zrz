class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> st = new ArrayDeque<>();
        for(int a: asteroids){
            boolean destroyed = false;
            while(!st.isEmpty() && st.peek() > 0 && a < 0){
                int top = st.peek();
                if(top < -a){
                    st.pop();
                    continue;
                }else if(top == -a){
                    st.pop();
                    destroyed = true;
                    break;
                }else{
                    destroyed = true;
                    break;
                }
            }
            if(!destroyed) st.push(a);
        }

        int[] res = new int[st.size()];
        for(int i = res.length - 1; i >= 0; i--){
            res[i] = st.pop();
        }
        return res;
    }
}