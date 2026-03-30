class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums) set.add(num);
        int max = 0;
        for(int x: set){
            if(set.contains(x-1)) continue;
            int count = 0;
            while(set.contains(x)){
                count++;
                x++;
            }
            max = Math.max(count, max);
        }
        return max;
    }
}
