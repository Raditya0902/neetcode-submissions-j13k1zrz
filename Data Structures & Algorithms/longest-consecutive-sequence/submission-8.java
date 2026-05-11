class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            set.add(nums[i]);
        }
        int maxLen = 0;
        for(int num: set){
            if(set.contains(num - 1)) continue;
            int curr = num, len = 0;
            while(set.contains(curr)){
                len++;
                curr++;
            }
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}
