class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        for(int[] t: intervals){
            if(t[0] > newInterval[1]){
                res.add(newInterval);
                newInterval = t;
            }else if(newInterval[0] > t[1]){
                res.add(t);
            }else{
                newInterval = new int[]{Math.min(t[0], newInterval[0]), Math.max(t[1], newInterval[1])};
            }
        }
        res.add(newInterval);
        return res.toArray(new int[res.size()][2]);
    }
}
