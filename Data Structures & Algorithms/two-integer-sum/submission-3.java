class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int remainingSum = target - nums[i];
            if(map.containsKey(remainingSum)){
                return new int[]{map.get(remainingSum), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
