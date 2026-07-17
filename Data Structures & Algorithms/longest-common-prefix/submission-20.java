class Solution {
    public String longestCommonPrefix(String[] strs) {
        String a = strs[0];
        for(int i = 0; i < a.length(); i++){
            for(int j = 1; j < strs.length; j++){
                if(strs[j].length() == i || strs[j].charAt(i) != a.charAt(i)){
                    return a.substring(0, i);
                }
            }
        }
        return a;
    }
}