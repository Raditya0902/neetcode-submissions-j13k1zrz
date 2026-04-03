class Solution {
    public int[] topKFrequent(int[] nums, int k) {  
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer>[] buckets = new ArrayList[nums.length + 1];

        for(int i = 0; i < buckets.length; i++) buckets[i] = new ArrayList<>();
        for(int key: map.keySet()){
            int val = map.get(key);
            buckets[val].add(key);
        }
        int[] ans = new int[k];
        int idx = 0;
        for(int i = buckets.length - 1; i >= 0; i--){
            List<Integer> ls = buckets[i];
            for(int x: ls){
                ans[idx++] = x;
                if(idx == k) return ans;
            }
        }

        return new int[0];
    }
}
