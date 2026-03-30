class MyHashMap {
    Node[] map;
    class Node{
        int key;
        int value;
        Node next;

        Node(){
            this.key = -1;
            this.value = -1;
            this.next = null;
        }

        Node(int key, int value){
            this.key = key;
            this.value = value;
            this.next = null;
        }

    }

    public MyHashMap() {
        map = new Node[1001];
        for(int i = 0; i < map.length; i++){
            map[i] = new Node();
        }
    }

    private int hashF(int key){
        return key % map.length;
    }
    
    public void put(int key, int value) {
        int keyIndex = hashF(key);
        Node curr = map[keyIndex]; //(-1,-1,null)
        while(curr.next != null){
            curr = curr.next;
            if(curr.key == key){
                curr.value = value;
                return;
            }
        }
        curr.next = new Node(key, value);
    }
    
    public int get(int key) {
        int keyIndex = hashF(key);
        Node curr = map[keyIndex]; //(-1,-1,null)
        while(curr.next != null){
            curr = curr.next;
            if(curr.key == key){
                return curr.value;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int keyIndex = hashF(key);
        Node curr = map[keyIndex]; //(-1,-1,null)
        Node prev = null;
        while(curr.next != null){
            prev = curr;
            curr = curr.next;
            if(curr.key == key){
                if(curr.next == null){
                    prev.next = null;
                }
                prev.next = curr.next;
                curr.next = null;
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