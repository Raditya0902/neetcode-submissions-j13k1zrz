class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Character>> row = new HashMap<>();
        HashMap<Integer, HashSet<Character>> col = new HashMap<>();
        HashMap<String, HashSet<Character>> box = new HashMap<>();

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char ch = board[i][j];
                if(ch == '.') continue;
                String boxString = (i/3) + "," + (j/3);
                row.putIfAbsent(i, new HashSet<>());
                col.putIfAbsent(j, new HashSet<>());
                box.putIfAbsent(boxString, new HashSet<>());
                if(row.get(i).contains(ch) || col.get(j).contains(ch) || box.get(boxString).contains(ch)) return false;
                row.get(i).add(ch);
                col.get(j).add(ch);
                box.get(boxString).add(ch);
            }
        }
        return true;
    }
}
