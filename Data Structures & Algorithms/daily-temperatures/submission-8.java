class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<int[]> st = new Stack<>();
        for(int i = 0; i < n; i++){
            int temp = temperatures[i];
            while(!st.isEmpty() && st.peek()[0] < temp){
                int[] p = st.pop();
                ans[p[1]] = i - p[1];
            }
            st.push(new int[]{temp, i});
        }
        return ans;
    }
}
