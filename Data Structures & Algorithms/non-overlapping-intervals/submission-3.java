class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int res = 0;
        Arrays.sort(intervals, (x,y)-> Integer.compare(x[0], y[0]));
        int prevEnd = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            int st = intervals[i][0], end = intervals[i][1];
            if(st >= prevEnd){
                prevEnd = end;
            }else{
                res++;
                prevEnd = Math.min(prevEnd, end);
            }
        }
        return res;
    }
}
