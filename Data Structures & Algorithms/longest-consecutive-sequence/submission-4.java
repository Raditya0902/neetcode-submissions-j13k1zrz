class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int n: nums) set.add(n);
        int max = 0;
        for(int it: set){
            if(set.contains(it - 1)) continue;
            int count = 1;
            while(set.contains(it + 1)){
                count++;
                it++;
            }
            max = Math.max(count, max);
        }
        return max;
    }
}
