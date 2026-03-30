class MyHashMap {
    List<List<Item>> table;
    
    class Item{
        int key;
        int value;
        public Item(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        table = new ArrayList<>(1000001);
        for(int i = 0; i < 1000001; i++){
            table.add(new ArrayList<>());
        }
    }

    private int hashFunction(int key) {return key % 1000001;}
    
    public void put(int key, int value) {
        int keyIndex = hashFunction(key);
        List<Item> bucket = table.get(keyIndex);
        for(Item item: bucket){
            if(item.key == key){
                item.value = value;
                return;
            }
        }
        bucket.add(new Item(key, value));

    }
    
    public int get(int key) {
        int keyIndex = hashFunction(key);
        List<Item> bucket = table.get(keyIndex);
        for(Item item: bucket){
            if(item.key == key){
                return item.value;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int keyIndex = hashFunction(key);
        List<Item> bucket = table.get(keyIndex);
        if(bucket == null || bucket.size() == 0) return;
        for(int i = 0; i < bucket.size(); i++){
            if(bucket.get(i).key == key){
                bucket.remove(i);
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