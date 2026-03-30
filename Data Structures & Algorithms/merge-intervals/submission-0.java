class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (x,y)->Integer.compare(x[0], y[0]));
        List<int[]> res = new ArrayList<>();
        for(int[] in: intervals){
            if(res.isEmpty() || res.get(res.size() - 1)[1] < in[0]){
                res.add(new int[]{in[0], in[1]});
            }else{
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], in[1]);
            }
        }
        int[][] ans = new int[res.size()][2];
        for(int i = 0; i < res.size(); i++){
            ans[i][0] = res.get(i)[0];
            ans[i][1] = res.get(i)[1];
        }
        return ans;
    }
}
