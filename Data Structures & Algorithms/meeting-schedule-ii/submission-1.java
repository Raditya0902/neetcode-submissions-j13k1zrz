/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        List<int[]> time = new ArrayList<>();
        for(Interval it: intervals){
            time.add(new int[]{it.start, 1});
            time.add(new int[]{it.end, -1});
        }
        time.sort((a,b)-> a[0] == b[0] ? a[1]-b[1] : a[0] - b[0]);

        int count = 0, res = 0;

        for(int[] it: time){
            if(it[1] == 1){
                count++;
                res = Math.max(count, res);
            }
            else{
                count--;
            }
        }
        
        return res;
    }
}
