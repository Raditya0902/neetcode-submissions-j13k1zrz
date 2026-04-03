class Solution {
    public boolean validPalindrome(String s) {
        if(h(s)) return true;
        for(int i = 0; i < s.length(); i++){
            String str = s.substring(0, i) + s.substring(i+1, s.length());
            if(h(str)) return true;
        }
        return false;
    }
    
    boolean h(String s){
        int l = 0;
        int r = s.length() - 1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}