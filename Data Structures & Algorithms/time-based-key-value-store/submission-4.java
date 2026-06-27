class TimeMap {
    Map<String, List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k-> new ArrayList<>()).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<Pair> ls = map.get(key); 
        String ans = "";
        if(ls == null) return ans;
        int l = 0, r = ls.size() - 1;
        while(l <= r){
            int mid = l + (r - l)/2;
            if(ls.get(mid).timestamp <= timestamp){
                ans = ls.get(mid).value;
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return ans;
    }
}

class Pair{
    String value;
    int timestamp;

    Pair(String value, int timestamp){
        this.value = value;
        this.timestamp = timestamp;
    }
}
