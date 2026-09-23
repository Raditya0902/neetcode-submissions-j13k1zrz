class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;

        for(int num: nums) set.add(num);
        for(int it: set){
            if(set.contains(it - 1)) continue;
            int count = 0, x = it;
            while(set.contains(x)){
                x++;
                count++;
            }
            max = Math.max(max, count);
        }

        return max;
    }
}
