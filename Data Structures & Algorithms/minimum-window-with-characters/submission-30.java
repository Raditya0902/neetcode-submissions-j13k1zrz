class Solution {
    public String minWindow(String s, String t) {
        if(t.isEmpty()) return "";
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> have = new HashMap<>();
        for(char ch: t.toCharArray()) need.put(ch, need.getOrDefault(ch, 0) + 1);

        int haveCount = 0;
        int l = 0, start = -1, res = s.length() + 1;

        for(int r = 0; r < s.length(); r++){
            char rc = s.charAt(r);
            have.put(rc, have.getOrDefault(rc, 0) + 1);
            if(need.containsKey(rc) && have.get(rc).equals(need.get(rc))) haveCount++;
            while(haveCount == need.size()){
                if((r-l+1) < res){
                    res = r - l + 1;
                    start = l;
                }
                char lc = s.charAt(l);
                have.put(lc, have.get(lc) - 1);
                if(need.containsKey(lc) && have.get(lc) + 1 == need.get(lc)) haveCount--;
                l++;
            }
        }
        return res == s.length() + 1 ? "" : s.substring(start, res + start);
    }
}
