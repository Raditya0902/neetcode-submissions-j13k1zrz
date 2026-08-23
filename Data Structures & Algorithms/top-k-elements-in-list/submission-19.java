class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int maxFreq = 0;
        for(int num: nums){
            map.put(num,map.getOrDefault(num, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(num));
        }

        List<Integer>[] buckets = new ArrayList[maxFreq+1];
        
        for(int key: map.keySet()){
            int val = map.get(key);
            if(buckets[val] == null) buckets[val] = new ArrayList<>();
            buckets[val].add(key);
        }
        
        int[] ans = new int[k];
        int idx = 0;

        for(int i = buckets.length - 1; i >= 1; i--){
            if(buckets[i] != null){
                if(idx == k) return ans;
                for(int j = 0; j < buckets[i].size(); j++){
                    ans[idx++] = buckets[i].get(j);
                }
            }
        }
        return ans;
    }
}
