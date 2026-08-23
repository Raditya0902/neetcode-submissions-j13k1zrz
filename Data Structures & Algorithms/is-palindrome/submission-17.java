class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while(i < j){
            while(i < j && !isAlphaNum(s.charAt(i))) i++;
            while(i < j && !isAlphaNum(s.charAt(j))) j--;
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
            else{
                i++;
                j--;
            }
        }
        return true;
    }

    boolean isAlphaNum(char ch){
        if((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) return true;
        return false;
    }
}
