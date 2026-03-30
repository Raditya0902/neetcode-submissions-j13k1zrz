class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] output = new int[n - k + 1];
        Deque<Integer> dq = new LinkedList<>();
        int l = 0;
        for(int r = 0; r < nums.length; r++){
            while(!dq.isEmpty() && nums[dq.getLast()] < nums[r]){
                dq.removeLast();
            }
            dq.addLast(r);
            if(l > dq.getFirst()) {dq.removeFirst();}
            if(r+1 >= k) {output[l] = nums[dq.getFirst()]; l++;}
        }
        return output;
    }
}
