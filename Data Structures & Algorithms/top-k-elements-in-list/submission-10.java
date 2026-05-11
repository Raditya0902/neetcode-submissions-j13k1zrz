class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int n = nums.length;
        List[] freq = new ArrayList[n + 1];
        for(int key: map.keySet()){
            int val = map.get(key);
            if(freq[val] == null) freq[val] = new ArrayList<>();
            freq[val].add(key);
        }

        int ind = 0;
        for(int i = n; i >= 0; i--){
            if(freq[i] != null){
                List<Integer> ls = freq[i];
                for(int x: ls){
                    if(ind == k) break; //this is before because if 2 == 2, that's not possible - index error
                    ans[ind++] = x;
                }
            }
        }
        return ans;
    }
}
