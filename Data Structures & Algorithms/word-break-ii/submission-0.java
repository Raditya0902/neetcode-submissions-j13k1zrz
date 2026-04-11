class Solution {
    Set<String> words;
    Map<Integer, List<String>> map;
    public List<String> wordBreak(String s, List<String> wordDict) {
        words = new HashSet<>(wordDict);
        map = new HashMap<>();
        return dfs(s, 0);
    }

    List<String> dfs(String s, int idx){
        if(map.containsKey(idx)){
            return map.get(idx);
        }
        List<String> res = new ArrayList<>();
        if(idx == s.length()){
            res.add("");
            return res;
        }

        for(int j = idx + 1; j <= s.length(); j++){
            String prefix = s.substring(idx, j);
            if(!words.contains(prefix)) continue;
            List<String> sufSentences = dfs(s, j);

            for(String sen: sufSentences){
                if(sen.isEmpty()){
                    res.add(prefix);
                }else{
                    res.add(prefix + " " + sen);
                }
            }
        }
        map.put(idx, res);
        return res;
    }
}