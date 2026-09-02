class CountSquares {
    Map<String, Integer> map;
    public CountSquares() {
        map = new HashMap<>();
    }
    
    public void add(int[] point) {
        int x = point[0], y = point[1];
        String key = getKey(x,y);
        map.put(key, map.getOrDefault(key, 0) + 1);
    }

    private String getKey(int x, int y){
         return x + "," + y;
    }
    
    public int count(int[] point) {
        int x1 = point[0], y1 = point[1];
        int total = 0;
        for(String key: map.keySet()){
            String[] part = key.split(",");
            int x2 = Integer.parseInt(part[0]), y2 = Integer.parseInt(part[1]);
            int dx = Math.abs(x1-x2);
            int dy = Math.abs(y1-y2);
            if(dx == 0 || dy == 0 || dx != dy) continue;
            int diagCount = map.get(key);
            int countCorner1 = map.getOrDefault(getKey(x2,y1), 0);
            int countCorner2 = map.getOrDefault(getKey(x1,y2), 0);
            total += diagCount * countCorner1 * countCorner2;
        }

        return total;
    }
}
