class Solution {
    List<String> res = new ArrayList<>();
    String[] digitsToChar = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return res;
        dfs(0, digits, "");
        return res;
    }

    void dfs(int idx, String digits, String curr){
        if(idx == digits.length()){
            res.add(curr);
            return;
        }
        String chars = digitsToChar[digits.charAt(idx) - '0'];
        for(char ch: chars.toCharArray()){
            dfs(idx+1, digits, curr + ch);
        }
    }
}
