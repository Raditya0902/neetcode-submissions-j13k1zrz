class CountSquares {
    Map<List<Integer>, Integer> map;
    List<List<Integer>> pts;
    public CountSquares() {
        map = new HashMap<>();
        pts = new ArrayList<>();
    }
    
    public void add(int[] point) {
        List<Integer> ls = Arrays.asList(point[0], point[1]);
        map.put(ls, map.getOrDefault(ls, 0) + 1);
        pts.add(ls);
    }
    
    public int count(int[] point) {
        int res = 0;
        int px = point[0], py = point[1];
        for(List<Integer> pt: pts){
            int x = pt.get(0), y = pt.get(1);
            if(Math.abs(px - x) != Math.abs(py - y) || x == px || y == py) continue;
            res += map.getOrDefault(Arrays.asList(x, py), 0) * map.getOrDefault(Arrays.asList(px, y), 0);
        }


        return res;
    }
}
