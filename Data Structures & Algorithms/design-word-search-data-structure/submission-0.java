class WordDictionary {
    Node root;
    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node node = root;
        for(char ch: word.toCharArray()){
            if(!node.containsKey(ch)){
                node.put(ch, new Node());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    boolean dfs(String word, int idx, Node node){
        if(node == null) return false;
        if(idx == word.length()) return node.getEnd();
        char ch = word.charAt(idx);
        if(ch == '.'){
            for(int i = 0; i < 26; i++){
                if(node.links[i] != null){
                    if(dfs(word, idx+1, node.links[i])) return true;
                }
            }
            return false;
        }
        if(!node.containsKey(ch)) return false;
        return dfs(word, idx+1, node.get(ch));
    }
}

class Node{
    Node links[];
    boolean flag;

    boolean containsKey(char ch){
        return links[ch-'a'] != null;
    }

    Node get(char ch){
        return links[ch-'a'];
    }

    void put(char ch, Node node){
        links[ch - 'a'] = node;
    }

    void setEnd(){
        flag = true;
    }

    boolean getEnd(){
        return flag;
    }

    Node(){
        links = new Node[26];
        flag = false;
    }
}