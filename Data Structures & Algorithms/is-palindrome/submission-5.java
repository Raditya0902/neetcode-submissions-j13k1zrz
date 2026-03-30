class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while(l < r){
            while(l < r && !isAlpha(s.charAt(l))) l++;
            while(l < r && !isAlpha(s.charAt(r))) r--;
            if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) return false;
            l++;
            r--;
        }

        return true;
    }

    boolean isAlpha(char ch){
        if(ch >= 'a' && ch <= 'z') return true;
        else if(ch >= 'A' && ch <= 'Z') return true;
        else if(ch >= '0' && ch <= '9') return true;
        return false;
    }

    
}
