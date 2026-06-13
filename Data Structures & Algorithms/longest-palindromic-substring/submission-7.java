class Solution {
    Boolean [][] memo;
    public String longestPalindrome(String s) {
        int n = s.length();
        memo = new Boolean[n][n];
        int maxLen = 1, start = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(isPalin(s, i, j) && j - i + 1 > maxLen){
                    maxLen = j - i + 1; start = i;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    boolean isPalin(String s, int i, int j){
        if(i >= j) return true;
        if(memo[i][j] != null) return memo[i][j];
        if(s.charAt(i) == s.charAt(j)){
            return memo[i][j] = isPalin(s, i+1, j-1);
        }
        return memo[i][j] = false;
    }
}
