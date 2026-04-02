class MyHashMap {
    Node[] map;

    class Node{
        int key;
        int value;
        Node next;

        Node(int key, int value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public MyHashMap() {
        map = new Node[10001];
        for(int i = 0; i < map.length; i++){
            map[i] = new Node(-1,-1,null);
        }
    }
    
    public void put(int key, int value) {
        int index = key % map.length;
        Node curr = map[index];
        while(curr.next != null){
            curr = curr.next;
            if(curr.key == key){
                curr.value = value;
                return;
            }
        }
        curr.next = new Node(key, value, null);

    }
    
    public int get(int key) {
        int index = key % map.length;
        Node curr = map[index];
        while(curr.next != null){
            curr = curr.next;
            if(curr.key == key) return curr.value;
        }
        return -1;
    }
    
    public void remove(int key) {
        int index = key % map.length;
        Node curr = map[index];
        while(curr.next != null){
            curr.next = curr.next.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */