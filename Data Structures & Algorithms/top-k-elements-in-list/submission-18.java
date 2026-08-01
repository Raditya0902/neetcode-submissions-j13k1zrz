class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] freq = new ArrayList[n + 1];
        for(int key: map.keySet()){
            int val = map.get(key);
            if(freq[val] == null) freq[val] = new ArrayList<>();
            freq[val].add(key);
        }
        
        int idx = 0;
        int[] ans = new int[k];
        for(int i = n; i >= 1; i--){
            if(freq[i] == null) continue;
            for(int j = 0; j < freq[i].size(); j++){
                if(idx == k) return ans;
                ans[idx++] = freq[i].get(j);
            }
        }
        return ans;
    }
}
