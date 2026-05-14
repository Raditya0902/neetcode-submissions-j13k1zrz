class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> st = new Stack<>();
        int n = temperatures.length;
        int[] ans = new int[n];

        for(int i = 0; i < n; i++){
            int temp = temperatures[i];
            while(!st.isEmpty() && st.peek()[0] < temp){
                int[] pair = st.pop();
                ans[pair[1]] = i - pair[1];
            }
            st.push(new int[]{temp, i});
        }
        return ans;
    }
}
