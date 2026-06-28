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
        int peak = find(mountainArr, n);
        int leftBS = bs(mountainArr, 0, peak, target, 0);
        if(leftBS == -1) return bs(mountainArr, peak + 1, n - 1, target, 1);
        return leftBS;
    }

    int bs(MountainArray arr, int l, int r, int target, int way){
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(way == 0){
                if(arr.get(mid) > target) r = mid - 1;
                else if(arr.get(mid) < target) l = mid + 1;
                else return mid;
            }else{
                if(arr.get(mid) > target) l = mid + 1;
                else if(arr.get(mid) < target) r = mid - 1;
                else return mid;
            }
        }
        return -1;
    }
    



    int find(MountainArray arr, int n){
        int l = 0, r = n - 1;
        while(l < r){
            int mid = l + (r - l) / 2;
            if(arr.get(mid) < arr.get(mid + 1)){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return l;
    }
}