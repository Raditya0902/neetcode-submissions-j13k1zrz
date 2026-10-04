class MyHashSet {
    boolean[] set;
    public MyHashSet() {
        set = new boolean[1001];
    }
    
    public void add(int key) {
        set[key%1001] = true;
    }
    
    public void remove(int key) {
        set[key%1001] = false;
    }
    
    public boolean contains(int key) {
        return set[key%1001];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */