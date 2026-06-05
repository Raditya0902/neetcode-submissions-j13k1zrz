class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (x, y)-> Integer.compare(x[0], y[0]));
        for(int[] it: intervals){
            if(res.isEmpty() || res.get(res.size() - 1)[1] < it[0]){
                res.add(new int[]{it[0], it[1]});
            }else{
                res.get(res.size() - 1)[1] = Math.max(it[1], res.get(res.size() - 1)[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
