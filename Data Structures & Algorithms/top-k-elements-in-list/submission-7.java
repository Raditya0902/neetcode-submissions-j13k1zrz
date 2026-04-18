class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new ArrayList[n + 1];
        for(int i = 0; i < buckets.length; i++) buckets[i] = new ArrayList<>();
        for(int key: map.keySet()){
            int val = map.get(key);
            buckets[val].add(key);
        }

        int[] ans = new int[k];
        int idx = 0;
        for(int i = buckets.length - 1; i >= 0; i--){
            List<Integer> ls = buckets[i];
            for(int num: ls){
                if(idx == k) break;
                ans[idx++] = num;
            }
        }
        return ans;

    }
}
