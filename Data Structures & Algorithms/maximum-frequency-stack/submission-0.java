class FreqStack {
    Map<Integer, Integer> freqMap;
    Map<Integer, Stack<Integer>> group;
    int maxFreq;
    public FreqStack() {
        freqMap = new HashMap<>();
        group = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        int freq = freqMap.getOrDefault(val, 0) + 1;
        freqMap.put(val, freq);
        maxFreq = Math.max(maxFreq, freq);
        group.putIfAbsent(freq, new Stack<>());
        group.get(freq).push(val);
    }
    
    public int pop() {
        int val = group.get(maxFreq).pop();
        freqMap.put(val, freqMap.get(val) - 1);
        if(group.get(maxFreq).isEmpty()){
            maxFreq--;
        }
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */