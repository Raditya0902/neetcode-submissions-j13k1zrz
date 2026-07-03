class FreqStack {
    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> group;
    int max;
    public FreqStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
        max = 0;
    }
    
    public void push(int val) {
        int f = freq.getOrDefault(val, 0) + 1;
        max = Math.max(max, f);
        freq.put(val, f);
        group.computeIfAbsent(f, k-> new Stack<>()).push(val);
    }
    
    public int pop() {
        int val = group.get(max).pop();
        freq.put(val, freq.get(val) - 1);
        if(group.get(max).isEmpty()) max--;
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */