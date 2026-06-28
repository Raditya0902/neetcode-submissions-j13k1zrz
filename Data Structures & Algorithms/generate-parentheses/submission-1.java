class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(n, n, sb, res);
        return res;
    }

    void helper(int open, int closed, StringBuilder sb, List<String> res){
        if(open == 0 && closed == 0){
            res.add(sb.toString());
            return;
        }

        if(open > 0){
            sb.append('(');
            helper(open - 1, closed, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(closed > open){
            sb.append(')');
            helper(open, closed - 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
