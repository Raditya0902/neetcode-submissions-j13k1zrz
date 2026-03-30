class Solution {
    public String minWindow(String s, String t) {
        int[] hash = new int[256];
        int n = s.length(), m = t.length();
        int count = 0, sIndex = -1;
        int minLen = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++){
            hash[t.charAt(i)]++;
        }
        int l = 0;
        for(int r = 0; r < n; r++){
            char rc = s.charAt(r);
            if(hash[rc] > 0) count++;
            hash[rc]--;
            while(count == m){
                if(r - l + 1 < minLen){
                    minLen =r - l + 1;
                    sIndex = l;
                }
                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)] > 0) count--;
                l++;
            }
        }
        return (sIndex == -1) ? "" : s.substring(sIndex, sIndex+minLen);
    }
}
