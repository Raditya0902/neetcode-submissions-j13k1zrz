class MyHashMap {
    Node[] map;
    int n;
    public MyHashMap() {
        this.n = 10001;
        this.map = new Node[n];
        for(int i = 0; i < n; i++){
            map[i] = new Node(-1,-1,null);
        }
    }
    
    public void put(int key, int value) {
        int index = key % n;
        Node curr = map[index];
        while(curr.next != null){
            curr = curr.next;
            if(curr.key == key){
                curr.val = value;
                return;
            }
        }
        curr.next = new Node(key, value, null);
    }
    
    public int get(int key) {
        int index = key % n;
        Node curr = map[index];
        while(curr.next != null){
            curr = curr.next;
            if(curr.key == key){
                return curr.val;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int index = key % n;
        Node curr = map[index];
        Node prev = null;
        while(curr.next != null){
            prev = curr;
            curr = curr.next;
            if(curr.key == key){
                prev.next = curr.next;
                curr.next = null;
                return;
            }
        }
    }
}

class Node{
    int key;
    int val;
    Node next;
    Node(int key, int val, Node next){
        this.key = key;
        this.val = val;
        this.next = next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */