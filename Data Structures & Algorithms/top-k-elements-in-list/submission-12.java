class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List[] freq = new ArrayList[n + 1];
        for(int key: map.keySet()){
            int val = map.get(key);
            if(freq[val] == null) freq[val] = new ArrayList();
            freq[val].add(key);
        }

        int[] ans = new int[k];
        int idx = 0;

        for(int i = n; i >= 0; i--){
            if(freq[i] != null){
                List<Integer> ls = freq[i];
                for(int x: ls){
                    if(idx == k) break;
                    ans[idx++] = x;
                }
            }
        }

        return ans;
    }
}
