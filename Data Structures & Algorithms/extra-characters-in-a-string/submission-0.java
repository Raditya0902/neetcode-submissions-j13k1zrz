class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Trie trie = new Trie();

        for(String word: dictionary){
            trie.addWord(word);
        }

        int n = s.length();
        int[] dp = new int[n+1];
        for(int i = n - 1; i >= 0; i--){
            dp[i] = 1 + dp[i+1];
            Node curr = trie.root;
            for(int j = i; j < n; j++){
                char ch = s.charAt(j);
                if(curr.children[ch-'a'] == null) break;
                curr = curr.children[ch - 'a'];
                if(curr.isEnd){
                    dp[i] = Math.min(dp[i], dp[j+1]);
                }
            }
        }
        return dp[0];
    }
}

class Node{
    Node[] children = new Node[26];
    boolean isEnd = false;
}

class Trie{
    Node root;
    Trie(){
        root = new Node();
    }

    void addWord(String word) {
        Node curr = root;
        for(char ch: word.toCharArray()){
            int idx = ch - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.isEnd = true;
    }
}