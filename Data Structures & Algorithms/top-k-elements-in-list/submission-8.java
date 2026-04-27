class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        List[] buckets = new ArrayList[n + 1];
        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int key: map.keySet()){
            int val = map.get(key);
            if(buckets[val] == null){
                buckets[val] = new ArrayList<>();
            }
            buckets[val].add(key);
        }

        int[] ans = new int[k];

        for(int i = buckets.length - 1; i >= 1; i--){
            List<Integer> ls = buckets[i];
            if(ls == null) continue;
            for(int ele: ls){
                ans[--k] = ele;
                if(k == 0) return ans;
            }
        }
        return ans;
    }
}
