class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<int[]> st = new Stack<>();
        int maxArea = 0;
        for(int i = 0; i < n; i++){
            int height = heights[i];
            int index = i;
            while(!st.isEmpty() && st.peek()[0] > height){
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
