class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Set<Character>> row = new HashMap<>();
        HashMap<Integer, Set<Character>> col = new HashMap<>();
        HashMap<String, Set<Character>> box = new HashMap<>();

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char ch = board[i][j];
                if(ch == '.') continue;
                String key = (i/3) + "," + (j/3);
                row.putIfAbsent(i, new HashSet<>());
                col.putIfAbsent(j, new HashSet<>());
                box.putIfAbsent(key, new HashSet<>());
                if(row.get(i).contains(ch) || col.get(j).contains(ch) || box.get(key).contains(ch)) return false;
                row.get(i).add(ch);
                col.get(j).add(ch);
                box.get(key).add(ch);
            }
        }
        return true;
    }
}
