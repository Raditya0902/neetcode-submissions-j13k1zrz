class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<String, Set<Character>> box = new HashMap<>();


        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.') continue;
                String key = (i/3) + "," + (j/3);
                rows.putIfAbsent(i, new HashSet<>());
                cols.putIfAbsent(j, new HashSet<>());
                box.putIfAbsent(key, new HashSet<>());
                if(rows.get(i).contains(board[i][j]) || 
                cols.get(j).contains(board[i][j]) || box.get(key).contains(board[i][j])){
                    return false;
                }

                rows.get(i).add(board[i][j]);
                cols.get(j).add(board[i][j]);
                box.get(key).add(board[i][j]);
            }
        }

        return true;
    }
}
