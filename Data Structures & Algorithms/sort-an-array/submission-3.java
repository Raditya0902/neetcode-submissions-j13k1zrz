class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    void mergeSort(int[] nums, int i, int j){
        if(i >= j) return;
        int mid = i + (j - i) / 2;
        mergeSort(nums, i, mid);
        mergeSort(nums, mid + 1, j);
        merge(nums, i, mid, j);
    }

    void merge(int[] nums, int low, int mid, int high){
        int left = low, right = mid + 1;
        int[] temp = new int[high - low + 1];
        int index = 0;
        while(left <= mid && right <= high){
            if(nums[left] <= nums[right]){
                temp[index++] = nums[left++];
            }else{
                temp[index++] = nums[right++];
            }
        }
        while(left <= mid){
            temp[index++] = nums[left++];
        }
        while(right <= high){
            temp[index++] = nums[right++];
        }

        for(int i = 0; i < temp.length; i++){
            nums[i + low] = temp[i];
        }
    }
}