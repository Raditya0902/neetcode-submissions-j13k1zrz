class Solution {
    public int[] topKFrequent(int[] nums, int k) {  
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums) map.put(num, map.getOrDefault(num, 0) + 1);
        List<Integer>[] freq = new ArrayList[nums.length + 1];
        for(int key: map.keySet()){
            int value = map.get(key);
            if(freq[value] == null) freq[value] = new ArrayList<>(); 
            freq[value].add(key);
        }
        int[] ans = new int[k];
        int index = 0;
        for(int i = freq.length - 1; i >= 0; i--){
            if(freq[i] != null){
                for(int num: freq[i]){
                    ans[index++] = num;
                    if(index == k) return ans;
                }
            }
        }
        return ans;
    }
}
