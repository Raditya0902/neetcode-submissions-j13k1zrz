class Solution {
    public int characterReplacement(String s, int k) {
        int len = 0;
        int l = 0, maxf = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for(int r = 0; r < s.length(); r++){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            maxf = Math.max(map.get(s.charAt(r)), maxf);
            while((r-l+1) - maxf > k){
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }
            len = Math.max(len, (r-l+1));
        }
        return len;
    }
}
