class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> have = new HashMap<>();

        for(char ch: t.toCharArray()){
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        int count = 0, minLen = Integer.MAX_VALUE;
        int l = 0, sIndex = -1;
        for(int r = 0; r < s.length(); r++){
            have.put(s.charAt(r), have.getOrDefault(s.charAt(r), 0) + 1);
            if(have.get(s.charAt(r)) == need.getOrDefault(s.charAt(r), -1)) count++;
            while(count == need.size()){
                if((r - l + 1) < minLen){
                    minLen = r - l + 1;
                    sIndex = l;
                }
                have.put(s.charAt(l), have.get(s.charAt(l)) - 1);
                if(have.get(s.charAt(l)) < need.getOrDefault(s.charAt(l), -1)) count--;
                l++;
            }
        }

        return sIndex == -1 ? "" : s.substring(sIndex, sIndex + minLen);
    }
}
