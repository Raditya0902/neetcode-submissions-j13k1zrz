class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] helper = new int[n+1];
        for(int t[]: trust){
            helper[t[0]]--;
            helper[t[1]]++;
        }
        for(int i=1; i<=n; i++){
            if(helper[i] == n - 1) return i;
        }
        return -1;
    }
}