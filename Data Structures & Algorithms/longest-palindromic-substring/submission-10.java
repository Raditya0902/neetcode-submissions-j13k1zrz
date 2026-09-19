class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        int ansLen = 0;

        for(int i = 0; i < s.length(); i++){
            int l = i, r = i;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                if((r - l + 1) > ansLen){
                    ansLen = r - l + 1;
                    ans = s.substring(l, r + 1);
                }
                l--;
                r++;
            }

            l = i; r = i + 1;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                if((r - l + 1) > ansLen){
                    ansLen = r - l + 1;
                    ans = s.substring(l, r + 1);
                }
                l--;
                r++;
            }
        }
        return ans;
    }
}
