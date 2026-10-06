class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(n > m) return false;
        int matches = 0;
        
        int[] f1 = new int[26];
        int[] f2 = new int[26];

        for(int i = 0; i < n; i++){
            f1[s1.charAt(i) - 'a']++;
            f2[s2.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26; i++) if(f1[i] == f2[i]) matches++;

        int l = 0;
        for(int r = n; r < m; r++){
            if(matches == 26) return true;
            char rc = s2.charAt(r);
            f2[rc - 'a']++;
            if(f1[rc-'a'] == f2[rc-'a']) matches++;
            else if(f1[rc-'a'] + 1 == f2[rc-'a']) matches--;
            char lc = s2.charAt(l);
            f2[lc-'a']--;
            if(f1[lc-'a'] == f2[lc-'a']) matches++;
            else if(f1[lc-'a'] - 1 == f2[lc-'a']) matches--;
            l++;
        }

        return matches == 26;
    }
}
