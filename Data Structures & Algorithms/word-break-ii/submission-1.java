class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for(String word: wordDict){
            trie.addWord(word);
        }
        Map<Integer, List<String>> map = new HashMap<>();
        return backtrack(s, 0, trie, map);
    }

    List<String> backtrack(String s, int idx, Trie trie, Map<Integer, List<String>> map){
        if(map.containsKey(idx)) return map.get(idx);

        List<String> res = new ArrayList<>();
        if(idx == s.length()){
            res.add("");
            return res;
        }

        TrieNode curr = trie.root;

        for(int i = idx; i < s.length(); i++){
            char ch = s.charAt(i);
            if(curr.children[ch - 'a'] == null) break;
            curr = curr.children[ch - 'a'];
            if(curr.isWord){
                String word = s.substring(idx, i+1);
                List<String> ls = backtrack(s, i+1, trie, map);

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

class Trie{
    TrieNode root;

    Trie(){
        root = new TrieNode();
    }

    void addWord(String word){
        TrieNode curr = root;
        for(char ch: word.toCharArray()){
            if(curr.children[ch - 'a'] == null) curr.children[ch-'a'] = new TrieNode();
            curr = curr.children[ch - 'a'];
        }
        curr.isWord = true;
    }
}

class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean isWord = false;
}