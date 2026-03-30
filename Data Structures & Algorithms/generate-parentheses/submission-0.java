class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ls = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(n, n, sb, ls);
        return ls;
    }

    void helper(int open, int close, StringBuilder sb, List<String> ls){
        if(open == 0 && close == 0){
            ls.add(sb.toString());
            return;
        }
        if(open > 0){
            sb.append('(');
            helper(open-1, close, sb, ls);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(close > open){
            sb.append(')');
            helper(open, close - 1, sb, ls);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
