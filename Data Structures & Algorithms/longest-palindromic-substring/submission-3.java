class Solution {
    public String longestPalindrome(String s) {
        return lps(s, new StringBuilder(s).reverse().toString());
    }

    String lps(String a, String b){
        int n = a.length();
        int[][] dp = new int[n+1][n+1];
        int res = 0;
        String ans = "";
        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < n + 1; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    if(dp[i][j] > res){
                        String temp = a.substring(i-dp[i][j], i);
                        String rev = new StringBuilder(temp).reverse().toString();
                        if(temp.equals(rev)){
                            ans = temp;
                            res = dp[i][j];
                        }
                    }
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }
}
