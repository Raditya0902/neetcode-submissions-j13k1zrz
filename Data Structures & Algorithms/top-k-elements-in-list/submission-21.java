class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int maxFreq = 0;
        for(int i = 0; i < n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(nums[i]));
        }

        List<Integer>[] buckets = new ArrayList[maxFreq + 1];

        for(int key: map.keySet()){
            int val = map.get(key);
            if(buckets[val] == null) buckets[val] = new ArrayList<>();
            buckets[val].add(key);
        }
        
        int[] ans = new int[k];
        int idx = 0;
        for(int i = maxFreq; i >= 1; i--){
            if(buckets[i] != null){
                for(int j = 0; j < buckets[i].size(); j++){
                    if(idx == k) return ans;
                    ans[idx++] = buckets[i].get(j);
                }
            }
        }
        
        return ans;
    }
}
