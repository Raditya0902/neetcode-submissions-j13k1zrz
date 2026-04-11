class Solution {
    int target;
    boolean[] used;
    int n;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int n: nums) sum += n;
        if(sum % k != 0) return false;

        this.n = nums.length;
        this.target = sum / k;
        Arrays.sort(nums);
        for(int i = 0; i < n / 2; i++){
            int temp = nums[i];
            nums[i] = nums[n - i - 1];
            nums[n - i - 1] = temp;
        }

        used = new boolean[n];
        return dfs(nums, k, 0, 0);
    }

    boolean dfs(int[] nums, int k, int currSum, int idx){
        if(k == 0) return true;
        if(currSum == target) return dfs(nums, k - 1, 0, 0);
        for(int i = idx; i < n; i++){
            if(used[i] || currSum + nums[i] > target) continue;
            used[i] = true;
            if(dfs(nums, k, currSum + nums[i], i + 1)) return true;
            used[i] = false;
            if(currSum == 0){
                 return false;
            }
        }
        return false;
    }
}