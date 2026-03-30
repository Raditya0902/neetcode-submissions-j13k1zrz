class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length, maxArea = 0;
        Stack<int[]> st = new Stack<>();
        for(int i = 0; i < n; i++){
            int start = i;
            while(!st.isEmpty() && st.peek()[1] > heights[i]){
                int[] top = st.pop();
                int index = top[0];
                int height = top[1];
                maxArea = Math.max(maxArea, height * (i - index));
                start = index;
            }
            st.push(new int[]{start, heights[i]});
        }
        for(int[] pair: st){
            int index = pair[0], height = pair[1];
            maxArea = Math.max(maxArea, height * (n - index));
        }
        return maxArea;
    }
}
