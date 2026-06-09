class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        mergeSort(0, n - 1, nums);
        return nums;
    }

    void mergeSort(int low, int high, int[] nums){
        if(low >= high) return;
        int mid = low + (high - low) / 2;
        mergeSort(low, mid, nums);
        mergeSort(mid+1, high, nums);
        merge(low, mid, high, nums);
    }

    void merge(int low, int mid, int high, int[] nums){
        int left = low, right = mid + 1;
        int[] temp = new int[high - low + 1];
        int idx = 0;
        while(left <= mid && right <= high){
            if(nums[left] <= nums[right]){
                temp[idx++] = nums[left++];
            }else{
                temp[idx++] = nums[right++];
            }
        }

        while(left <= mid){
            temp[idx++] = nums[left++];
        }

        while(right <= high){
            temp[idx++] = nums[right++];
        }

        for(int i = 0; i < temp.length; i++){
            nums[i + low] = temp[i];
        }
    }
}