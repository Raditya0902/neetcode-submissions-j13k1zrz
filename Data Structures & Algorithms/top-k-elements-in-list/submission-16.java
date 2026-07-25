class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums) map.put(num, map.getOrDefault(num, 0) + 1);
        List<Integer>[] freq = new ArrayList[n + 1];

        for(int key: map.keySet()){
            int val = map.get(key);
            if(freq[val] == null) freq[val] = new ArrayList<>();
            freq[val].add(key);
        }
        
        int[] ans = new int[k];
        int idx = 0;

        for(int i = n; i >= 1; i--){
            
            if(freq[i] != null){
                for(int s = 0; s < freq[i].size(); s++){
                    if(idx == k){
                        return ans;
                    }
                    ans[idx++] = freq[i].get(s);
                }
            }
        }

        return ans;
    }
}
