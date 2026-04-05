class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        if(n == 1) return true;
        for(int num: nums){
            if(num == 1) return false;
        }
        DSU dsu = new DSU(1000001);
        for(int num: nums){
            Set<Integer> fs = primesF(num);
            for(int it: fs){
                dsu.union(it, num);
            }
        }

        int root = dsu.find(nums[0]);
        for(int num: nums){
            if(dsu.find(num) != root) return false;
        }
        return true;
    }

    Set<Integer> primesF(int n){
        Set<Integer> factors = new HashSet<>();
        int d = 2;
        while(d*d <= n){
            while(n%d == 0){
                factors.add(d);
                n = n / d;
            }
            d++;
        }
        if(n > 1) factors.add(n);
        return factors;
    }

}

class DSU{
     int[] par; 
     int[] size; 
     DSU(int n){ 
        this.par = new int[n]; 
        this.size = new int[n]; 
        for(int i = 0; i < n; i++){ 
            par[i] = i; 
            size[i] = 1; 
        } 
    } 
    int find(int x){ 
        if(x != par[x]){
            par[x] = find(par[x]);
        }
        return par[x];
    } 
    boolean union(int u, int v){ 
        int pu = find(u), pv = find(v); 
        if(pu == pv) return false; 
        if(size[pu] <= size[pv]){ 
            par[pu] = pv; 
            size[pv] += size[pu]; 
        }
        else{ 
            par[pv] = pu; 
            size[pu] += size[pv]; 
        } 
        return true; 
    }
}