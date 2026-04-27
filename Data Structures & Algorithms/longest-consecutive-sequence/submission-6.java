class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }

        int max = 0;
        for(int it: set){
            if(set.contains(it - 1)) continue;
            int count = 0;
            while(set.contains(it)){
                it++;
                count++;
            }
            max = Math.max(count, max);
        }
        return max;
    }
}
