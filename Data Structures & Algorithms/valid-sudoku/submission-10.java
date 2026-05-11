class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> row = new HashMap<>();
        Map<Integer, Set<Character>> col = new HashMap<>();
        Map<String, Set<Character>> box = new HashMap<>();

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.') continue;
                String boxStr = i/3 + "," + j/3;
                row.putIfAbsent(i, new HashSet<>());
                col.putIfAbsent(j, new HashSet<>());
                box.putIfAbsent(boxStr, new HashSet<>());
                if(row.get(i).contains(board[i][j]) || col.get(j).contains(board[i][j]) || box.get(boxStr).contains(board[i][j])){
                    return false;
                }
                row.get(i).add(board[i][j]);
                col.get(j).add(board[i][j]);
                box.get(boxStr).add(board[i][j]);
            }
        }
        return true;
    }
}
