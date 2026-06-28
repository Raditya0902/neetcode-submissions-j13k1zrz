class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(0,s, new ArrayList<>());
        return res;
    }

    void dfs(int idx, String s, List<String> ls){
        if(idx == s.length()){
            res.add(new ArrayList<>(ls));
            return;
        }
        for(int i = idx; i < s.length(); i++){
            if(palin(idx, i, s)){
                ls.add(s.substring(idx, i+1));
                dfs(i+1,s,ls);
                ls.remove(ls.size() - 1);
            }
        }
    }

    boolean palin(int l, int r, String s){
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;r--;
        }
        return true;
    }
}
