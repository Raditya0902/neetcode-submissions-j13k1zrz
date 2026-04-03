class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, Integer> eToId = new HashMap<>();
        HashMap<String, String> eToName = new HashMap<>();
        int id = 0;
        for(List<String> acc: accounts){
            String name = acc.get(0);
            for(int i = 1; i < acc.size(); i++){
                if(!eToId.containsKey(acc.get(i))){
                    eToId.put(acc.get(i), id++);
                }
                eToName.put(acc.get(i), name);
            }
        }

        DSU dsu = new DSU(id);
        for(List<String> acc: accounts){
            int emailId = eToId.get(acc.get(1));
            for(int i = 2; i < acc.size(); i++){
                dsu.union(emailId, eToId.get(acc.get(i)));
            }
        }

        Map<Integer, List<String>> groups = new HashMap<>();
        for(String email: eToId.keySet()){
            int parent = dsu.find(eToId.get(email));
            groups.computeIfAbsent(parent, k->new ArrayList<>()).add(email);
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
        this.par = new int[n];
        this.size = new int[n];
        for(int i = 0; i < n; i++){
            this.size[i] = 1;
            this.par[i] = i;
        }
    }

    int find(int u){
        if(par[u] == u) return u;
        return find(par[u]);
    }

    boolean union(int u, int v){
        int pu = find(u);
        int pv = find(v);

        if(pu == pv) return false;

        if(size[pu] < size[pv]){ //attach smaller tree under larger tree
            par[pu] = pv;
            size[pv] += size[pu];
        }else{
            par[pv] = pu;
            size[pu] += size[pv];
        }
        return true;
    }
}