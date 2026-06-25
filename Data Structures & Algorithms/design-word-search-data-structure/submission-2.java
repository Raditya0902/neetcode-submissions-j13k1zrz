class WordDictionary {
    Node root;
    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
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

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    boolean dfs(String word, int idx, Node root){
        Node curr = root;
        for(int i = idx; i < word.length(); i++){
            char ch = word.charAt(i);
            if(ch == '.'){
                for(Node child: curr.children){
                    if(child != null && dfs(word, i+1, child)) return true;
                }
                return false;
            }else{
                if(curr.children[ch-'a'] == null) return false;
                curr = curr.children[ch-'a'];
            }
        }
        return curr.isEnd;
    }
}

class Node{
    Node[] children = new Node[26];
    boolean isEnd = false;
}