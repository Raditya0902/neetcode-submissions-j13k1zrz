class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        for(int[] t: intervals){
            if(t[0] > newInterval[1]){
                ans.add(newInterval);
                newInterval = t;
            }else if(newInterval[0] > t[1]){
                ans.add(t);
            }else{
                newInterval = new int[]{Math.min(t[0], newInterval[0]), Math.max(t[1], newInterval[1])};
            }
        }
        ans.add(newInterval);
        return ans.toArray(new int[ans.size()][ans.get(0).length]);
    }
}
