class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<int[]> dq = new ArrayDeque<>();
        int[] res = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++){
            int temp = temperatures[i];
            while(!dq.isEmpty() && dq.peek()[0] < temp){
                int[] pair = dq.pop();
                res[pair[1]] = i - pair[1];
            }
            dq.push(new int[]{temp, i});
        }
        return res;
    }
}
