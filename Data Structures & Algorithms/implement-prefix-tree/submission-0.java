class PrefixTree {
    private Node root;
    public PrefixTree() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        for(char ch: word.toCharArray()){
            if(node.containsKey(ch)){
                node = node.get(ch);
            }else{
                node.put(ch, new Node());
                node = node.get(ch);
            }
        }
        node.setFlag();
    }
    
    public boolean search(String word) {
        Node node = root;
        for(char ch: word.toCharArray()){
            if(node.containsKey(ch)){
                node = node.get(ch);
            }else{
                return false;
            }
        }
        return node.getFlag();
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;
        for(char ch: prefix.toCharArray()){
            if(node.containsKey(ch)){
                node = node.get(ch);
            }else{
                return false;
            }
        }
        return node != null;
    }
}

class Node{
    Node links[];
    boolean flag;

    boolean containsKey(char ch){
        return links[ch - 'a'] != null;
    }

    void put(char ch, Node node){
        links[ch - 'a'] = node;
    }

    Node get(char ch){
        return links[ch - 'a'];
    }


    Node(){
        links = new Node[26];
        flag = false;
    }

    void setFlag(){
        flag = true;
    }

    boolean getFlag(){
        return flag;
    }
}