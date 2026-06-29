class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(k > nums.length) return false;

        int sum = 0;
        for(int n: nums) sum += n;
        if(sum % k  != 0) return false;

        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        while(l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++; r--;
        }

        int len = sum / k;
        int[] parts = new int[k];
        return dfs(parts, nums, 0, len, k);
    }

    boolean dfs(int[] parts, int[] nums, int idx, int len, int k){
        if(idx == nums.length){
            for(int part: parts) if(part != len) return false;
            return true;
        }

        int part = nums[idx];
        for(int i = 0; i < k; i++){
            if(parts[i] + part > len) continue;
            parts[i] += part;
            if(dfs(parts, nums, idx+1, len, k)) return true;
            parts[i] -= part;
        }
        return false;
        
    }
}