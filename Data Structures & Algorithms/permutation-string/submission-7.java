class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if(n > m) return false;
        HashMap<Character, Integer> c1 = new HashMap<>();
        HashMap<Character, Integer> c2 = new HashMap<>();
        for(char ch = 'a'; ch <= 'z'; ch++) {
            c1.put(ch, 0);
            c2.put(ch, 0);
        }
        for(int i = 0; i < n; i++){
            c1.put(s1.charAt(i), c1.getOrDefault(s1.charAt(i), 0) + 1);
            c2.put(s2.charAt(i), c2.getOrDefault(s2.charAt(i), 0) + 1);
        }
        int matches = 0, l = 0;
        for(char ch = 'a'; ch <= 'z'; ch++){
            if(c1.get(ch) == c2.get(ch)) matches++;
        }

        for(int r = n; r < m; r++){
            if(matches == 26) return true;
            c2.put(s2.charAt(r), c2.get(s2.charAt(r)) + 1);
            if(c1.get(s2.charAt(r)) == c2.get(s2.charAt(r))) matches++;
            else if(c1.get(s2.charAt(r)) + 1 == c2.get(s2.charAt(r))) matches--;
            c2.put(s2.charAt(l), c2.get(s2.charAt(l)) - 1);
            if(c1.get(s2.charAt(l)) == c2.get(s2.charAt(l))) matches++;
            else if(c1.get(s2.charAt(l)) - 1 == c2.get(s2.charAt(l))) matches--;
            l++;
        }
        return matches == 26;
    }
}
