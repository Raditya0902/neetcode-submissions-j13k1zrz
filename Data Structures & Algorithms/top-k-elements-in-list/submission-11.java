class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List[] buckets = new ArrayList[n + 1];
        
        for(int key: map.keySet()){
            int val = map.get(key);
            if(buckets[val] == null) buckets[val] = new ArrayList<>();
            buckets[val].add(key);
        }


        int[] ans = new int[k];
        int idx = 0;
        for(int i = n; i >= 0; i--){
            if(buckets[i] != null){
                List<Integer> ls = buckets[i];
                for(int x: ls){
                    if(idx == k) return ans;
                    ans[idx++] = x;
                }
            }
        }
        return ans;
    }
}
