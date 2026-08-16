class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums) set.add(num);
        int len = 0;

        for(int it: set){
            if(set.contains(it - 1)) continue;
            int count = 0, x = it;
            while(set.contains(x)){
                count++;
                x++;
            }
            if(count > len) len = count;
        }
        return len;
    }
}
