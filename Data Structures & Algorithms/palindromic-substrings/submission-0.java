class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        for(int i = 0; i < n; i++){
            count += expFromCenter(s, i, i);
            count += expFromCenter(s, i, i + 1);
        }
        return count;
    }

    int expFromCenter(String s, int l, int r){
        int count = 0;
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
            count++;
        }
        return count;
    }
}
