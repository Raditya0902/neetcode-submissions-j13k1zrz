class Solution {
    int[] memo;
    public int numDecodings(String s) {
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return helper(s.length() - 1, s);
    }

    int helper(int curr, String s){
        if(curr == 0){
            if(s.charAt(curr) == '0') return 0;
            else return 1;
        }

        if(curr == -1){
            return 1;
        }

        if(memo[curr] != -1) return memo[curr];

        if(s.charAt(curr) == '0'){
            if(s.charAt(curr-1) == '1' || s.charAt(curr-1) == '2'){
                return memo[curr] = helper(curr - 2, s);
            }else{
                return memo[curr] = 0;
            }
        }

        int ways = 0;
        if (s.charAt(curr - 1) == '1' || (s.charAt(curr - 1) == '2' && s.charAt(curr) <= '6')){
            ways = helper(curr-1, s) + helper(curr-2, s);
        }else{
            ways = helper(curr - 1, s);
        }
        return memo[curr] = ways;
    }
}
