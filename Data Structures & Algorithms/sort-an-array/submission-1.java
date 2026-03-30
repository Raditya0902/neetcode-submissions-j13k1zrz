class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
    void mergeSort(int[] nums, int i, int j){
        if(i >= j) return;
        int mid = i + (j - i)/2;
        mergeSort(nums, i, mid);
        mergeSort(nums, mid + 1, j);
        merge(nums, i, mid, j);
    }

    void merge(int[] nums, int low, int mid, int high){
        int left = low, right = mid + 1;
        int[] temp = new int[high - low + 1];
        int i = 0;
        while(left <= mid && right <= high){
            if(nums[left] <= nums[right]){
                temp[i++] = nums[left];
                left++;
            }else{
                temp[i++] = nums[right];
                right++;
            }
        }
        while(left <= mid){
            temp[i++] = nums[left];
            left++;
        }
        while(right <= high){
            temp[i++] = nums[right];
            right++;
        }

        for(int j = 0; j < temp.length; j++){
            nums[low + j] = temp[j];
        }
    }
}