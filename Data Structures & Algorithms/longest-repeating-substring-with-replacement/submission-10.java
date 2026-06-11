class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0, maxFreq = 0;
        int l = 0;
        for(int r = 0; r < s.length(); r++){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(s.charAt(r)));
            while((r - l + 1) - maxFreq > k){
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                maxFreq = Math.max(maxFreq, map.get(s.charAt(l)));
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
}
