class MyHashMap {
    Node[] map;
    public MyHashMap() {
        map = new Node[1000];
        for(int i = 0; i < map.length; i++) map[i] = new Node();
    }
    
    public void put(int key, int value) {
        int index = Math.floorMod(key, map.length);
        Node curr = map[index];
        while(curr.next != null){
            if(curr.next.key == key){
                curr.next.value = value;
                return;
            }
            curr = curr.next;
        }
        curr.next = new Node(key, value, null);

    }
    
    public int get(int key) {
        int index = Math.floorMod(key, map.length);
        Node curr = map[index];
        while(curr.next != null){
            if(curr.next.key == key){
                return curr.next.value;
            }
            curr = curr.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        int index = Math.floorMod(key, map.length);
        Node curr = map[index];
        while(curr.next != null){
            if(curr.next.key == key){
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }
}

class Node{
    int key;
    int value;
    Node next;

    public Node(int key, int value, Node next){
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public Node(){
        this(-1,-1,null);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */