class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] pairs = new int[n][2];
        for(int i = 0; i < n; i++){
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }
        Arrays.sort(pairs, (a,b)->Integer.compare(b[0], a[0]));
        Stack<Double> st = new Stack<>();
        for(int[] p: pairs){
            double time = (target - p[0])/(double)p[1];
            st.push(time);
            while(st.size() >= 2 && st.peek() <= st.get(st.size() - 2)){
                st.pop();
            }
        }
        return st.size();
    }
}