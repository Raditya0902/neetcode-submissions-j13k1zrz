class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] in = new int[n + 1];
        int[] out = new int[n + 1];
        Arrays.fill(in, 0);
        Arrays.fill(out, 0);

        for(int[] t: trust){
            int a = t[0], b = t[1];
            in[b] += 1;
            out[a] += 1;
        }

        for(int i = 1; i <= n; i++){
            if(in[i] == n - 1 && out[i] == 0) return i;
        }
        return -1;
    }
}