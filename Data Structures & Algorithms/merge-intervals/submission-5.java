class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[0] - b[0]);
        List<int[]> merged = new ArrayList<>();
        for(int[] it: intervals){
            if(merged.isEmpty() || merged.get(merged.size() - 1)[1] < it[0]){
                merged.add(it);
            }else{
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], it[1]);
            }
        }
        return merged.toArray(new int[merged.size()][merged.get(0).length]);
    }
}
