class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, Integer> eToID = new HashMap<>();
        HashMap<String, String> eToName = new HashMap<>();
        int id = 0;

        for(List<String> acc: accounts){
            String name = acc.get(0);
            for(int i = 1; i < acc.size(); i++){
                String email = acc.get(i);
                if(!eToID.containsKey(email)){
                    eToID.put(email, id++);
                }
                eToName.put(email, name);
            }
        }

        DSU dsu = new DSU(id);

        for(List<String> acc: accounts){
            int firstEmailId = eToID.get(acc.get(1));
            for(int i = 2; i < acc.size(); i++){
                dsu.union(firstEmailId, eToID.get(acc.get(i)));
            }
        }

        HashMap<Integer, List<String>> groups = new HashMap<>();
        for(String email: eToID.keySet()){
            int parent = dsu.find(eToID.get(email));
            groups.computeIfAbsent(parent, k-> new ArrayList<>()).add(email);
        }

        List<List<String>> res = new ArrayList<>();
        for(int parent: groups.keySet()){
            List<String> emails = groups.get(parent);
            Collections.sort(emails);
            List<String> merged = new ArrayList<>();
            merged.add(eToName.get(emails.get(0)));
            merged.addAll(emails);
            res.add(merged);
        }
        return res;
    }
}

class DSU{
    int[] par;
    int[] size;

    DSU(int n){
        par = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++){
            par[i] = i;
            size[i] = 1;
        }
    }

    int find(int u){
        if(u == par[u]) return u;
        return find(par[u]);
    }

    boolean union(int u, int v){
        int pu = find(u);
        int pv = find(v);

        if(pu == pv) return false;
        if(size[pu] <= size[pv]){//attach smaller tree to the larger one
            par[pu] = pv;
            size[pu] += size[pv];
        }else{
            par[pv] = pu;
            size[pv] += size[pu];
        }
        return true;
    }
}