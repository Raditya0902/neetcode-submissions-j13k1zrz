class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        int l = 0;

        for(int r = 0; r < n; r++){
            while(!dq.isEmpty() && l > dq.getFirst()) dq.removeFirst();
            while(!dq.isEmpty() && nums[r] > nums[dq.getLast()]) dq.removeLast();

            dq.addLast(r);
            if(r >= k - 1) res[l++] = nums[dq.getFirst()];
        }
        return res;
    }
}
