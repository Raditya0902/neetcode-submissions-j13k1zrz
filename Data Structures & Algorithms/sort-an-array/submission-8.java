class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    void mergeSort(int[] nums, int low, int high){
        if(low >= high) return;
        int mid = low + (high - low)/2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid+1, high);
        merge(nums, low, mid, high);
    }

    void merge(int[] nums, int low, int mid, int high){
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

        for(int i = 0; i < idx; i++){
            nums[i+low] = temp[i];
        }
    }
}