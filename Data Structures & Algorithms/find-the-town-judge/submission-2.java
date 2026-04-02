class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] helper = new int[n + 1];
        for(int[]t: trust){
            int a = t[0], b = t[1];
            helper[a]--;
            helper[b]++;
        }
        for(int i = 1; i <= n; i++){
            if(helper[i] == n - 1) return i;
        }
        return -1;
    }
}