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
        int leftBs = bs(mountainArr, 0, peak, target, true);
        if(leftBs != -1) return leftBs;
        return bs(mountainArr, peak + 1, n - 1, target, false);
    }

    int bs(MountainArray arr, int l, int r, int target, boolean ascending){
        while(l <= r){
            int mid = l + (r - l)/2;
            int val = arr.get(mid);
            if(ascending){
                if(val == target) return mid;
                else if(val > target) r = mid - 1;
                else l = mid + 1;
            }else{
                if(val == target) return mid;
                else if(val > target) l = mid + 1;
                else r = mid - 1;
            }
        }
        return -1;
    }

    int find(MountainArray arr, int n){
        int l = 0, r = n - 1;
        while(l < r){
            int mid = l + (r - l) / 2;
            int val = arr.get(mid);
            if(val < arr.get(mid + 1)) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}