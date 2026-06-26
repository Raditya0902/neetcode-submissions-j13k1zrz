class CountSquares {
    Map<String, Integer> map;
    public CountSquares() {
        map = new HashMap<>();
    }
    
    public void add(int[] point) {
        int x = point[0], y = point[1];
        String key = getKey(x, y);
        map.put(key, map.getOrDefault(key, 0) + 1);
    }

    private String getKey(int x, int y){
        return x + "," + y;
    }  
    
    public int count(int[] point) {
        int x1 = point[0];
        int y1 = point[1];
        int total = 0;

        for(String key: map.keySet()){
            String[] parts = key.split(",");
            int x2 = Integer.parseInt(parts[0]);
            int y2 = Integer.parseInt(parts[1]);

            int dx = Math.abs(x2 - x1);
            int dy = Math.abs(y2 - y1);
            if(dx == 0 || dy == 0 || dx != dy) continue;
            
            int diagonalCount = map.get(key);
            int countCorner1 = map.getOrDefault(getKey(x1,y2), 0);
            int countCorner2 = map.getOrDefault(getKey(x2,y1), 0);
            total += diagonalCount * countCorner1 * countCorner2;
        }
        return total;
    }
}
