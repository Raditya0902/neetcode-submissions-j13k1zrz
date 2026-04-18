class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n: nums) set.add(n);
        int max = 0;
        for(int it: set){
            if(set.contains(it-1)) continue;
            else{
                int x = it;
                int count = 0;
                while(set.contains(x)){
                    count++;
                    x = x + 1;
                }
                max = Math.max(count, max);
            }
        }
        return max;
    }
}
