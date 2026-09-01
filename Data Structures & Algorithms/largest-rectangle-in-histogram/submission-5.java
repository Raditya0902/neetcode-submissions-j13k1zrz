class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int max = 0;
        Stack<int[]> st = new Stack<>();
        
        for(int i = 0; i < heights.length; i++){
            int height = heights[i];
            int index = i;
            while(!st.isEmpty() && st.peek()[0] > height){
                int[] pair = st.pop();
                max = Math.max(max, pair[0] * (i - pair[1]));
                index = pair[1];
            }
            st.push(new int[]{height, index});
        }

        while(!st.isEmpty()){
            int[] pair = st.pop();
            max = Math.max(max, pair[0] * (n - pair[1]));
        }

        return max;
    }
}
