class Solution {

    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    TrieNode root;
    List<String> res;
    int rows, cols;
    char[][] board;

    TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String word: words){
            TrieNode node = root;
            for(char ch: word.toCharArray()){
                int idx = ch - 'a';
                if(node.children[idx] == null){
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }
            node.word = word;
        }
        return root;
    }

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.rows = board.length;
        this.cols = board[0].length;
        this.res = new ArrayList<>();
        this.root = buildTrie(words);

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                dfs(r,c,root);
            }
        }

        return res;
    }

    void dfs(int r, int c, TrieNode par){
        char ch = board[r][c];
        if(ch == '#') return;
        TrieNode node = par.children[ch - 'a'];
        if(node == null) return; 

        if(node.word != null){
            res.add(node.word);
            node.word = null;
        }

        board[r][c] = '#';

        if(r > 0) dfs(r - 1, c, node);
        if(r < rows - 1) dfs(r + 1, c, node);
        if(c > 0) dfs(r, c - 1, node);
        if(c < cols - 1) dfs(r, c + 1, node);
        board[r][c] = ch;
    }
}
