class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        mergeSort(nums, 0, n - 1);
        return nums;
    }

    void mergeSort(int[] nums, int left, int right){
        if(left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
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
            nums[i + low] = temp[i];
        }
    }
}

