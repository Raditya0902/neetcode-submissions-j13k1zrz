class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Character>> rows = new HashMap<>();
        HashMap<Integer, HashSet<Character>> cols = new HashMap<>();
        HashMap<String, HashSet<Character>> squares = new HashMap<>();
        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                if(board[r][c] == '.') continue;
                String squareNum = (r/3) + "," + (c/3);
                rows.putIfAbsent(r, new HashSet<>());
                cols.putIfAbsent(c, new HashSet<>());
                squares.putIfAbsent(squareNum, new HashSet<>());
                if(rows.get(r).contains(board[r][c]) || 
                   cols.get(c).contains(board[r][c]) || 
                   squares.get(squareNum).contains(board[r][c])
                ) return false;
                rows.get(r).add(board[r][c]);
                cols.get(c).add(board[r][c]);
                squares.get(squareNum).add(board[r][c]);
            }
        }
        return true;
    }
}
