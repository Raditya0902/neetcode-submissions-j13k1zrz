class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        int l = 0;
        Deque<Integer> dq = new ArrayDeque<>();

        for(int r = 0; r < nums.length; r++){
            while(!dq.isEmpty() && l > dq.getFirst()) dq.removeFirst();
            while(!dq.isEmpty() && nums[dq.getLast()] < nums[r]) dq.removeLast();
            dq.add(r);
            if(r >= k - 1) ans[l++] = nums[dq.getFirst()];
        }

        return ans;
    }
}
