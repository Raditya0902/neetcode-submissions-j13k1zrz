class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = 0, l = 0;
        HashSet<Character> set = new HashSet<>();
        for(int r = 0; r < s.length(); r++){
            while(set.contains(s.charAt(r))){
                set.remove(s.charAt(l++));
            }
            set.add(s.charAt(r));
            len = Math.max(len, (r - l + 1));
        }
        return len;
    }
}
