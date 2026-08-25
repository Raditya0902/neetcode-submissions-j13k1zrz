class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(n > m) return false;

        int[] c1 = new int[26];
        int[] c2 = new int[26];

        for(int i = 0; i < n; i++){
            c1[s1.charAt(i) - 'a']++;
            c2[s2.charAt(i) - 'a']++;
        }
        
        int matches = 0, l = 0;
        for(int i = 0; i < 26; i++) if(c1[i] == c2[i]) matches++;

        for(int r = n; r < m; r++){
            if(matches == 26) return true;
            char rc = s2.charAt(r);
            c2[rc - 'a']++;
            if(c1[rc - 'a'] == c2[rc - 'a']) matches++;
            else if(c1[rc - 'a'] + 1 == c2[rc - 'a']) matches--;
            char lc = s2.charAt(l);
            c2[lc - 'a']--;
            if(c1[lc - 'a'] == c2[lc - 'a']) matches++;
            else if(c1[lc - 'a'] - 1 == c2[lc - 'a']) matches--;
            l++;
        }

        return matches == 26 ? true : false;
    }
}
