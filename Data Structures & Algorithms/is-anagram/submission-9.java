class Solution {
    public boolean isAnagram(String s, String t) {
        int freq[] = new int[26];
        for(int i = 0; i < s.length(); i++){
            int pos = s.charAt(i) - 'a';
            freq[pos]++;
        }
        for(int i = 0; i < t.length(); i++){
            int pos = t.charAt(i) - 'a';
            freq[pos]--;
        }
        for(int i = 0; i < 26; i++){
            if(freq[i] != 0) return false;
        }
        return true;
    }
}
