class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(s, 0, new ArrayList<>());
        return res;
    }

    void dfs(String s, int idx, List<String> ls){
        if(idx == s.length()){
            res.add(new ArrayList<>(ls));
            return;
        }

        for(int i = idx; i < s.length(); i++){
            if(palin(s, idx, i)){
                ls.add(s.substring(idx, i + 1));
                dfs(s, i+1, ls);
                ls.remove(ls.size() - 1);
            }
        }
    }

    boolean palin(String s, int l, int r){
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
