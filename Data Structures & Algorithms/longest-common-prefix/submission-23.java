class Solution {
    public String longestCommonPrefix(String[] strs) {
        String pre = strs[0];
        for(int i = 0; i < pre.length(); i++){
            for(int j = 1; j < strs.length; j++){
                if(strs[j].length() == i || pre.charAt(i) != strs[j].charAt(i)){
                    return pre.substring(0,i);
                }
            }
        }
        return pre;
    }
}