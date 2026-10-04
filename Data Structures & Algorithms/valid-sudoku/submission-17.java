class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> boxes = new HashMap<>();

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char ch = board[i][j];
                if(ch == '.') continue;
                String key = i/3 + "," + j/3;
                rows.putIfAbsent(i, new HashSet<>());
                cols.putIfAbsent(j, new HashSet<>());
                boxes.putIfAbsent(key, new HashSet<>());
                if(rows.get(i).contains(ch) || cols.get(j).contains(ch) || boxes.get(key).contains(ch)) return false;
                rows.get(i).add(ch);
                cols.get(j).add(ch);
                boxes.get(key).add(ch);
            }
        }
        return true;
    }
}
