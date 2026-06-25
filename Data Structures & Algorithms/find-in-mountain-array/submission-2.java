/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int peak = findPeak(mountainArr, n);
        int leftRes = bs(mountainArr, 0, peak, target, 1);
        if(leftRes != -1) return leftRes;
        return bs(mountainArr, peak + 1, n - 1, target, -1);
    }

    int bs(MountainArray arr, int left, int right, int target, int way){
        while(left <= right){
            int mid = left + (right - left) / 2;
            int value = arr.get(mid);
            if(value == target) return mid;
            if(way == 1){
                if(value > target){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                if(value > target){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    int findPeak(MountainArray arr, int n){
        int left = 0;
        int right = n - 1;

        while(left < right){
            int mid = left + (right - left) / 2;
            if(arr.get(mid) < arr.get(mid + 1)){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}