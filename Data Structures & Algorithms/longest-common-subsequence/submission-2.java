class Solution {
    private int[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        memo = new int[text1.length()+1][text2.length()+1];
        for(int i = 0; i < text1.length() + 1; i++){
            for(int j = 0; j < text2.length() + 1; j++){
                memo[i][j] = -1;
            }
        }
        return f(text1, text2, text1.length(), text2.length());
    }
    
    int f(String text1, String text2, int i, int j){
        if(i == 0 || j == 0) return 0;
        if(memo[i-1][j-1] != -1) return memo[i-1][j-1];
        if(text1.charAt(i-1) == text2.charAt(j-1)){
            return memo[i-1][j-1] = 1 + f(text1,text2, --i,--j);
        }else{
            return memo[i-1][j-1] =  Math.max(f(text1,text2,i, j - 1), f(text1,text2,i-1,j));
        }
    }
}
