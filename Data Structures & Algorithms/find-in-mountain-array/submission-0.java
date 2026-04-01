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
        int leftResult = bsI(mountainArr, 0, peak, target);
        if(leftResult != -1) return leftResult;
        return bsD(mountainArr, peak+1, n-1, target);
    }

    int findPeak(MountainArray arr, int n){
        int left = 0, right = n - 1;
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

    int bsI(MountainArray mountainArr, int left, int right, int target){
        while(left <= right){
            int mid = left + (right - left) / 2;
            int value = mountainArr.get(mid);
            if(value == target) return mid;
            else if(value > target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return -1;
    }

    int bsD(MountainArray mountainArr, int left, int right, int target){
        while(left <= right){
            int mid = left + (right - left) / 2;
            int value = mountainArr.get(mid);
            if(value == target) return mid;
            else if(value > target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return -1;
    }
}