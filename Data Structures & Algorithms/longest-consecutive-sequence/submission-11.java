class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for(int n: nums) set.add(n);
        for(int it: set){
            if(set.contains(it - 1)) continue;
            else{
                int count = 0, x = it;
                while(set.contains(x)){
                    count++;
                    x++;
                }
                max = Math.max(count ,max);
            }
        }
        return max;
    }
}
