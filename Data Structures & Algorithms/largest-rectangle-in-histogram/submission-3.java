class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<int[]> st = new ArrayDeque<>();
        int maxArea = 0;
        for(int i = 0; i < n; i++){
            int height = heights[i];
            int index = i;
            while(!st.isEmpty() && height < st.peek()[0]){
                int[] pair = st.pop();
                maxArea = Math.max(maxArea, (i - pair[1]) * pair[0]);
                index = pair[1];
            }
            st.push(new int[]{height, index});
        }

        while(!st.isEmpty()){
            int[] pair = st.pop();
            maxArea = Math.max(maxArea, (n - pair[1]) * pair[0]);
        }
        return maxArea;
    }
}
