class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0 || strs == null) return "";
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        int minLength = Math.min(first.length(), last.length());
        int i = 0;
        while(i < minLength && first.charAt(i) == last.charAt(i)) i++;
        return first.substring(0,i);
    }
}