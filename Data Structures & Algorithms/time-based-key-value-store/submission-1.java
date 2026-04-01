class TimeMap {
    HashMap<String, List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k-> new ArrayList<>()).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        List<Pair> ls = map.get(key);
        int left = 0, right = ls.size() - 1;
        String ans = "";
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(ls.get(mid).timeStamp <= timestamp){
                ans = ls.get(mid).value;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return ans;
    }
}

class Pair{
    int timeStamp;
    String value;
    public Pair(int timeStamp, String value){
        this.timeStamp = timeStamp;
        this.value = value;
    }
}