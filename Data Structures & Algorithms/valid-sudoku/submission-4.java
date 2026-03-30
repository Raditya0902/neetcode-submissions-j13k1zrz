class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Character>> rows = new HashMap<>();
        HashMap<Integer, HashSet<Character>> cols = new HashMap<>();
        HashMap<String, HashSet<Character>> squares = new HashMap<>();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.') continue;
                String seq = (i/3) + "," + (j/3);
                rows.putIfAbsent(i, new HashSet<>());
                cols.putIfAbsent(j, new HashSet<>());
                squares.putIfAbsent(seq, new HashSet<>());
                if(rows.get(i).contains(board[i][j]) ||
                cols.get(j).contains(board[i][j]) ||
                squares.get(seq).contains(board[i][j])) return false;
                rows.get(i).add(board[i][j]);
                cols.get(j).add(board[i][j]);
                squares.get(seq).add(board[i][j]);
            }
        }
        return true;

    }
}
