class MyHashSet {
    boolean[] set;
    int n;
    public MyHashSet() {
        this.n = 10001;
        this.set = new boolean[n];
    }
    
    public void add(int key) {
        set[key%n] = true;
    }
    
    public void remove(int key) {
        set[key%n] = false;
    }
    
    public boolean contains(int key) {
        return set[key%n];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */