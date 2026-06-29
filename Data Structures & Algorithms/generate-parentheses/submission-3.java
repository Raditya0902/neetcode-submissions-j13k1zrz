class Solution {
    List<String> ls = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> generateParenthesis(int n) {
        dfs(n, n);
        return ls;
    }

    void dfs(int open, int close){
        if(open == 0 && close == 0){
            ls.add(sb.toString());
            return;
        }
        if(open > 0){
            sb.append('(');
            dfs(open - 1, close);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(close > open){
            sb.append(')');
            dfs(open, close - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
