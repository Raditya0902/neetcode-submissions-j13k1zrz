class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(k > nums.length) return false;
        
        int sum = 0;
        for(int n: nums) sum += n;
        if(sum % k != 0) return false;

        Arrays.sort(nums);

        int len = sum / k;
        int[] parts = new int[k];

        return dfs(nums, parts, len, k, nums.length - 1);
    }

    boolean dfs(int[] nums, int[] parts, int len, int k, int idx){
        if(idx < 0){
            for(int part: parts){
                if(part != len) return false;
            }
            return true;
        }
        
        int part = nums[idx];
        for(int i = 0; i < k; i++){
            if(parts[i] + part > len) continue;
            parts[i] += part;
            if(dfs(nums, parts, len, k, idx-1)) return true;
            parts[i] -= part;
        }
        return false;
    }


}