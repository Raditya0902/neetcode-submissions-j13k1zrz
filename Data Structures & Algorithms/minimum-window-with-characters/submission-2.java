class Solution {
    public String minWindow(String s, String t) {
        int[] hash = new int[256];
        for(char ch: t.toCharArray()){
            hash[ch]++;
        }
        int minLen = Integer.MAX_VALUE, l = 0, count = 0, sIndex = -1;
        for(int r = 0; r < s.length(); r++){
            char rc = s.charAt(r);
            if(hash[rc] > 0) count++;
            hash[rc]--;
            while(count == t.length()){
                if(r - l + 1 < minLen){
                    minLen = r - l + 1;
                    sIndex = l;
                }

                char lc = s.charAt(l);
                hash[lc]++;
                if(hash[lc] > 0) count--;
                l++;
            }
        }
        return sIndex == - 1 ? "" : s.substring(sIndex, sIndex + minLen);
    }
}
