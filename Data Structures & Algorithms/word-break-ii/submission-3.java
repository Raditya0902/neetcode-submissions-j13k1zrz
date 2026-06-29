class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Map<Integer, List<String>> map = new HashMap<>();

        return dfs(0, s, set, map);
    }

    List<String> dfs(int idx, String s, Set<String> set, Map<Integer, List<String>> map){  
        if(map.containsKey(idx)) return map.get(idx);

        List<String> res = new ArrayList<>();
        if(idx == s.length()){
            res.add("");
            return res;
        }

        for(int i = idx; i < s.length(); i++){
            String word = s.substring(idx, i + 1);
            if(set.contains(word)){
                List<String> ls = dfs(i+1,s,set,map);
                for(String str: ls){
                    if(str.isEmpty()) res.add(word);
                    else res.add(word + " " + str);
                }
            }
        }

        map.put(idx, res);
        return res;
    }
}