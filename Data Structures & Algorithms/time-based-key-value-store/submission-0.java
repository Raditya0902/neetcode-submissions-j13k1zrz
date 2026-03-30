class TimeMap {
    private Map<String, List<Pair<Integer, String>>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> values = map.getOrDefault(key, new ArrayList<>());
        int left = 0, right = values.size() - 1;
        String ans = "";
        while(left <= right){
            int mid = (left + right) / 2;
            if(values.get(mid).getKey() <= timestamp){
                ans = values.get(mid).getValue();
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return ans;
    }

    static class Pair<K,V> {
        private final K key;
        private final V value;
        
        public Pair(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey(){
            return key;
        }

        public V getValue(){
            return value;
        }
    }
}