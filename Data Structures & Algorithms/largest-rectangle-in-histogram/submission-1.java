class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length, max = 0;
        Stack<int[]> st = new Stack<>();
        for(int i = 0; i < n; i++){
            int start = i;
            while(!st.isEmpty() && st.peek()[1] > heights[i]){
                int[] top = st.pop();
                int index = top[0], height = top[1];
                max = Math.max(max, height * (i - index));
                start = index;
            }
            st.push(new int[]{start, heights[i]});
        }
        for(int[] pair: st){
            int index = pair[0];
            int height = pair[1];
            max = Math.max(max, height * (n - index));
        }
        return max;
    }
}
