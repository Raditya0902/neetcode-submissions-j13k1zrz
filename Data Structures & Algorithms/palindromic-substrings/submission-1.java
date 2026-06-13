class Solution {
    Boolean[][] memo;
    public int countSubstrings(String s) {
        int n = s.length();
        memo = new Boolean[n][n];
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(isPalin(s, i, j)) count++;
            }
        }
        return count;
    }

    boolean isPalin(String s, int i, int j){
        if(i >= j) return true;
        if(memo[i][j] != null) return memo[i][j];
        if(s.charAt(i) == s.charAt(j)) return memo[i][j] = isPalin(s, i + 1, j - 1);
        return memo[i][j] = false;
    }
}
