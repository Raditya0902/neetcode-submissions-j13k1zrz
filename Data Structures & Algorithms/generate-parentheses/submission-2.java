class Solution {
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> generateParenthesis(int n) {
        helper(n, n);
        return res;
    }

    void helper(int open, int close){
        if(open == 0 && close == 0){
            res.add(sb.toString());
            return;
        }

        if(open > 0){
            sb.append('(');
            helper(open - 1, close);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(close > open){
            sb.append(')');
            helper(open, close - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
