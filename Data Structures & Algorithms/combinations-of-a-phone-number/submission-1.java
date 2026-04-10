class Solution {
    List<String> res = new ArrayList<>();
    String[] digitsToChar = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return res;
        dfs(0, "", digits);
        return res;
    }

    void dfs(int i, String curr, String digits){
        if(i == digits.length()){
            res.add(curr);
            return;
        }

        String chars = digitsToChar[digits.charAt(i) - '0'];
        for(char ch: chars.toCharArray()){
            dfs(i + 1, curr + ch, digits);
        }
    }
}
