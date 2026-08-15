class MyHashSet {
    boolean[] set;
    int n;
    public MyHashSet() {
        n = 10001;
        set = new boolean[n];
    }
    
    public void add(int key) {
        int idx = key % n;
        set[idx] = true;
    }
    
    public void remove(int key) {
        int idx = key % n;
        set[idx] = false;

    }
    
    public boolean contains(int key) {
        return set[key % n];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */