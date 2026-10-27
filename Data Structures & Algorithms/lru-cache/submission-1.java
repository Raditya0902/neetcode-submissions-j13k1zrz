class LRUCache {
    int capacity;
    Map<Integer, Node> map;
    Node head;
    Node tail;

    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        Node (int k, int v){
            key = k;
            value = v;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node == null) return -1;
        moveToHead(node);
        return node.value;
    }

    void addFirst(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    void moveToHead(Node node){
        removeNode(node);
        addFirst(node);
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if(node != null){
            node.value = value;
            moveToHead(node);
        }else{
            if(map.size() == capacity){
                Node lru = tail.prev;
                removeNode(lru);
                map.remove(lru.key);
            }
            Node newNode = new Node(key,value);
            map.put(key, newNode);
            addFirst(newNode);
        }
    }
}
