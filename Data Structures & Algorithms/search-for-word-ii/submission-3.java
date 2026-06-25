class Solution {
    List<String> res = new ArrayList<>();
    int rows;
    int cols;
    public List<String> findWords(char[][] board, String[] words) {
        this.rows = board.length;
        this.cols = board[0].length;
        Trie trie = new Trie();

        for(String word: words) trie.addWord(word);

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                dfs(board, r, c, trie.root);
            }
        }
        return res;
    }

    void dfs(char[][] board, int r, int c, Node node){
        if(r < 0 || r >= rows || c < 0 || c >= cols) return;
        char ch = board[r][c];
        if(ch == '#') return;
        Node next = node.children[ch - 'a'];
        if(next == null) return;
        if(next.word != null){
            res.add(next.word);
            next.word = null;
        }
        board[r][c] = '#';
        dfs(board, r+1, c, next);
        dfs(board, r, c-1, next);
        dfs(board, r-1, c, next);
        dfs(board, r, c+1, next);

        board[r][c] = ch;
    }
}

class Node {
    Node[] children = new Node[26];
    String word = null;
}

class Trie {
    Node root = new Node();

    void addWord(String word) {
        Node curr = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.word = word;
    }
}