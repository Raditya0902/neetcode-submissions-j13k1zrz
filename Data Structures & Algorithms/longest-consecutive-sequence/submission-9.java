class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n: nums) set.add(n);

        int max = 0;
        for(int num: set){
            if(set.contains(num - 1)) continue;
            int count = 0, x = num;
            while(set.contains(x)){
                count++;
                x++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
