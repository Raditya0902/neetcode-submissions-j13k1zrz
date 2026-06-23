class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if(s.charAt(n-1) == '1') return false;
        boolean[] reachable = new boolean[n];
        reachable[0] = true;
        int pre = 0;

        for(int i = 1; i < n; i++){
            if(i >= minJump && reachable[i - minJump]) pre++;
            if(i > maxJump && reachable[i- maxJump - 1]) pre--;
            if(pre > 0 && s.charAt(i) == '0') reachable[i] = true;
        }
        return reachable[n-1];
    }
}