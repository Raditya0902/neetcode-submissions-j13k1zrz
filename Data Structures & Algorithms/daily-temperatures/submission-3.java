class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<int[]> deque = new ArrayDeque<>();
        int[] res = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++){
            int temperature = temperatures[i];
            while(!deque.isEmpty() && deque.peek()[0] < temperature){
                int[] pair = deque.pop();
                res[pair[1]] = i - pair[1];
            }
            deque.push(new int[]{temperatures[i], i});
        }
        return res;
    }
}
