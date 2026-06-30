class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> boxes = new HashMap<>();

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.') continue;
                rows.putIfAbsent(i, new HashSet<>());
                cols.putIfAbsent(j, new HashSet<>());
                boxes.putIfAbsent(i/3 + "," + j/3, new HashSet<>());

                if(rows.get(i).contains(board[i][j]) ||
                cols.get(j).contains(board[i][j]) ||
                boxes.get(i/3 + "," + j/3).contains(board[i][j])) return false;

                rows.get(i).add(board[i][j]);
                cols.get(j).add(board[i][j]);
                boxes.get(i/3 + "," + j/3).add(board[i][j]);
            }
        }
        return true;
    }
}
