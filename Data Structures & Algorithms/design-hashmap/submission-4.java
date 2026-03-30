class MyHashMap {
    Node[] map;

    class Node{
        int key;
        int value;
        Node next;

        Node(int key, int value, Node next){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    public MyHashMap() {
        map = new Node[1001];
        for(int i = 0; i < map.length; i++) map[i] = new Node(-1,-1,null);
    }
    
    public void put(int key, int value) {
        int keyIndex = key % map.length;
        Node curr = map[keyIndex];
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
        int keyIndex = key % map.length;
        Node curr = map[keyIndex];
        while(curr.next != null){
            curr = curr.next;
            if(curr.key == key){
                return curr.value;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int keyIndex = key % map.length;
        Node curr = map[keyIndex];
        Node temp = null;
        while(curr.next != null){
            temp = curr;
            curr = curr.next;
            if(curr.key == key){
                if(curr.next == null) {temp.next = null; return;}
                temp.next = curr.next;
                curr.next = null;
                return;
            }
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