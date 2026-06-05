class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (x,y)->Integer.compare(x[0], y[0]));

        int prevEnd = intervals[0][1];
        int res = 0;
        for(int i = 1; i < intervals.length; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(start >= prevEnd){
                prevEnd = end;
            }else{
                res++;
                prevEnd = Math.min(end, prevEnd);
            }
        }
        return res;
    }
}
