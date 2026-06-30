class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    void mergeSort(int[] nums, int l, int r){
        if(l >= r) return;
        int mid = l + (r - l)/2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid+1,r);
        merge(nums, l, mid, r);
    }

    void merge(int[] nums, int l, int mid, int r){
        int left = l, right = mid + 1;
        int[] temp = new int[r - l + 1];
        int idx = 0;
        while(left <= mid && right <= r){
            if(nums[left] <= nums[right]) temp[idx++] = nums[left++];
            else temp[idx++] = nums[right++];
        }

        while(left <= mid) temp[idx++] = nums[left++];
        while(right <= r) temp[idx++] = nums[right++];

        for(int i = 0; i < temp.length; i++) nums[i+l] = temp[i];
    }
}