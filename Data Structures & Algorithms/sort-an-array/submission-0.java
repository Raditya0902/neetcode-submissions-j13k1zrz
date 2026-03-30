class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(0, nums.length - 1, nums);
        return nums;
    }
    void mergeSort(int low, int high, int[] nums){
        if(low >= high) return;
        int mid = low + (high - low) / 2;
        mergeSort(low, mid, nums);
        mergeSort(mid+1,high, nums);
        sort(low, mid, high, nums);
    }
    void sort(int low, int mid, int high, int[] nums){
        int left = low, right = mid + 1;
        int[] temp = new int[high - low + 1];
        int i = 0;
        while(left <= mid && right <= high){
            if(nums[left] <= nums[right]){
                temp[i++] = nums[left++];
            }else{
                temp[i++] = nums[right++];
            }
        }
        while(left<=mid){
            temp[i++] = nums[left++];
        }
        while(right <= high){
            temp[i++] = nums[right++];
        }
        for(int k = 0; k < temp.length; k++){
            nums[low + k] = temp[k];
        }
    }
}