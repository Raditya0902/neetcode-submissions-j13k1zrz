class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(0, s);
        return res;
    }

    void dfs(int idx, String s){
        if(idx == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = idx; i < s.length(); i++){
            if(palin(s, idx, i)){
                path.add(s.substring(idx, i+1));
                dfs(i+1, s);
                path.remove(path.size() - 1);
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
