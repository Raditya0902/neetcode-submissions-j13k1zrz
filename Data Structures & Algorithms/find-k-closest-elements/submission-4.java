class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0, h = arr.length - k;
        while(l < h){
            int mid = l + (h - l) / 2;
            if(x - arr[mid] > arr[mid+k] - x){
                l = mid + 1;
            }else{
                h = mid;
            }
        }

        List<Integer> ls = new ArrayList<>();

        for(int i = l; i < l + k; i++){
            ls.add(arr[i]);
        }
        
        return ls;
    }
}