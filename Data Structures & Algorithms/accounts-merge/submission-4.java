class Solution {
    int[] par;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        par = new int[n];
        for(int i = 0; i < n; i++) par[i] = i;
        Map<String, Integer> emailToAccount = new HashMap<>();
        for(int i = 0; i < n; i++){
            for(int j = 1; j < accounts.get(i).size(); j++){
                String email = accounts.get(i).get(j);
                if(emailToAccount.containsKey(email)){
                    union(i, emailToAccount.get(email));
                }else{
                    emailToAccount.put(email, i);
                }
            }
        }

        Map<Integer, TreeSet<String>> rootToEmails = new HashMap<>();
        for(String email: emailToAccount.keySet()){
            int root = find(emailToAccount.get(email));
            rootToEmails.computeIfAbsent(root, k -> new TreeSet<>()).add(email);
        }

        List<List<String>> res = new ArrayList<>();
        for(int root: rootToEmails.keySet()){
            List<String> merged = new ArrayList<>();
            merged.add(accounts.get(root).get(0));
            merged.addAll(rootToEmails.get(root));
            res.add(merged);
        }
        return res;
    }

    int find(int x){
        if(par[x] != x) par[x] = find(par[x]);
        return par[x];
    }

    void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA != rootB) par[rootB] = rootA;
    }
}