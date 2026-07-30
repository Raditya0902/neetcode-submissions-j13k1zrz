class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];

        for(int i = 0; i < prefix.length(); i++){
            for(int j = 1; j < strs.length; j++){
                if(i == strs[j].length() || prefix.charAt(i) != strs[j].charAt(i)){
                    return prefix.substring(0,i);
                }
            }
        }
        return prefix;
    }
}