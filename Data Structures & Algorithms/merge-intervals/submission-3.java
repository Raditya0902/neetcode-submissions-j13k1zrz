class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (x,y)->Integer.compare(x[0], y[0]));
        List<int[]> res = new ArrayList<>();

        for(int[] interval: intervals){
            if(res.isEmpty() || res.get(res.size() - 1)[1] < interval[0]){
                res.add(new int[]{interval[0], interval[1]});
            }else{
                res.get(res.size()-1)[1] = Math.max(res.get(res.size()-1)[1] , interval[1]);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
