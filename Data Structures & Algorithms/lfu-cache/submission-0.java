class LFUCache {

    int capacity;
    int minFreq;
    Map<Integer, Node> keyToNode;
    Map<Integer, DLL> freqToList;

    class Node{
        int key;
        int val;
        int freq;
        Node prev;
        Node next;
        Node (int k, int v){
            this.key = k;
            this.val = v;
            this.freq = 1;
        }
    }

    class DLL{
        Node head;
        Node tail;
        int size;

        DLL(){
            this.head = new Node(0,0);
            this.tail = new Node(0,0);
            head.next = tail;
            tail.prev = head;
        }

        void addFirst(Node node){
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        void remove(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeLast(){
            if(size == 0) return null;
            Node last = tail.prev;
            remove(last);
            return last;
        }
    }

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.keyToNode = new HashMap<>();
        this.freqToList = new HashMap<>();
    }
    
    public int get(int key) {
        Node node = keyToNode.get(key);
        if(node == null) return -1;
        updateFreq(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(capacity == 0) return;

        Node node = keyToNode.get(key);
        if(node != null){
            node.val = value;
            updateFreq(node);
        }else{
            if(keyToNode.size() == capacity){
                DLL minList = freqToList.get(minFreq);
                Node evicted = minList.removeLast();
                keyToNode.remove(evicted.key);
            }
            Node newNode = new Node(key, value);
            keyToNode.put(key, newNode);
            minFreq = 1;
            freqToList.computeIfAbsent(1, k-> new DLL()).addFirst(newNode);
        }
    }

    void updateFreq(Node node){
        int currFreq = node.freq;
        DLL currList = freqToList.get(currFreq);
        currList.remove(node);
        if(currFreq == minFreq && currList.size == 0){
            minFreq++;
        }
        node.freq++;
        freqToList.computeIfAbsent(node.freq, k-> new DLL()).addFirst(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */