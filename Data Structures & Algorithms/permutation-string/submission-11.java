class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if(n > m) return false;
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        for(int i = 0; i < n; i++){
            c1[s1.charAt(i) - 'a']++;
            c2[s2.charAt(i) - 'a']++;
        }
        int matches = 0;
        for(int i = 0; i < 26; i++){
            if(c1[i] == c2[i]) matches++;
        }
        int l = 0;
        for(int r = n; r < m; r++){
            if(matches == 26) return true;
            c2[s2.charAt(r) - 'a']++;
            if(c1[s2.charAt(r) - 'a'] == c2[s2.charAt(r) - 'a']) matches++;
            else if(c1[s2.charAt(r) - 'a'] + 1 == c2[s2.charAt(r) - 'a']) matches--;
            c2[s2.charAt(l) - 'a']--;
            if(c1[s2.charAt(l) - 'a'] == c2[s2.charAt(l) - 'a']) matches++;
            else if(c1[s2.charAt(l) - 'a'] - 1 == c2[s2.charAt(l) - 'a']) matches--;
            l++;
        }
        return matches == 26 ? true : false;
    }
}
