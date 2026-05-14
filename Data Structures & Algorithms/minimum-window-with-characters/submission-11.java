class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> have = new HashMap<>();

        for(char ch: t.toCharArray()){
            need.put(ch, need.getOrDefault(ch,0) + 1);
        }
        
        int count = 0, minLen = Integer.MAX_VALUE;
        int l = 0, start = -1;

        for(int r = 0; r < s.length(); r++){
            char rc = s.charAt(r);
            have.put(rc, have.getOrDefault(rc, 0) + 1);
            if(have.get(rc) == need.getOrDefault(rc, -1)) count++;
            while(count == need.size()){
                if((r - l + 1) < minLen){
                    minLen = r - l + 1;
                    start = l;
                } 
                char lc = s.charAt(l);
                have.put(lc, have.get(lc) - 1);
                if(have.get(lc) < need.getOrDefault(lc, -1)) count--;
                l++;
            }
        }

        return start == -1 || minLen == Integer.MAX_VALUE ?  "" : s.substring(start, start + minLen);
    }
}
