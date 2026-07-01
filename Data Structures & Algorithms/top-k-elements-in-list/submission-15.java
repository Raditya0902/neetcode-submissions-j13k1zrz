class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new ArrayList[n+1];
        
        int[] ans = new int[k];
        int idx = 0;

        for(int key: map.keySet()){
            int val = map.get(key);
            if(buckets[val] == null) buckets[val] = new ArrayList<>();
            buckets[val].add(key);
        }

        for(int i = n; i >= 1; i--){
            if(buckets[i] == null) continue;
            for(int j = 0; j < buckets[i].size(); j++){
                if(idx == k) return ans;
                ans[idx++] = buckets[i].get(j);
            }
        }

        return ans;
    }
}
