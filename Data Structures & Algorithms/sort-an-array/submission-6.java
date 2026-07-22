class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        mergeSort(nums, 0, n - 1);
        return nums;
    }

    void mergeSort(int[] nums, int l, int h){
        if(l >= h) return;
        int mid = l + (h - l) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid+1, h);
        merge(nums, l, mid, h);
    }

    void merge(int[] nums, int l, int mid, int h){
        int left = l, right = mid + 1;
        int k = 0;
        int[] temp = new int[h - l + 1];
        while(left <= mid && right <= h){
            if(nums[left] <= nums[right]){
                temp[k++] = nums[left++];
            }else{
                temp[k++] = nums[right++];
            }
        }

        while(left <= mid){
            temp[k++] = nums[left++];
        }

        while(right <= h){
            temp[k++] = nums[right++];
        }

        for(int i = 0; i < temp.length; i++){
            nums[l + i] = temp[i];
        }
    }
}