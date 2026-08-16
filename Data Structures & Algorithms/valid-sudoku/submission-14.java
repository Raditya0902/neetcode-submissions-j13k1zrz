class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> box = new HashMap<>();

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.') continue;
                char ch = board[i][j];
                String key = i/3 + "," + j/3;

                rows.putIfAbsent(i, new HashSet<>());
                cols.putIfAbsent(j, new HashSet<>());
                box.putIfAbsent(key, new HashSet<>());

                if(rows.get(i).contains(ch) || cols.get(j).contains(ch) ||                      box.get(key).contains(ch)) return false;

                rows.get(i).add(ch);
                cols.get(j).add(ch);
                box.get(key).add(ch);
            }
        }
        return true;
    }
}
