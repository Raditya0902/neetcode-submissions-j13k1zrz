class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for(int i = 0; i < equations.size(); i++){
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double val = values[i];
            graph.computeIfAbsent(a, k-> new HashMap<>()).put(b, val);
            graph.computeIfAbsent(b, k-> new HashMap<>()).put(a, 1.0/val);
        }
        double res[] = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++){
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);

            if(!graph.containsKey(src) || !graph.containsKey(dest)){
                res[i] = -1.0;
            }else if(src.equals(dest)) res[i] = 1.0;
            else{
                res[i] = dfs(src, dest, new HashSet<>(), graph, 1.0);
            }
        }
        return res;
    }

    double dfs(String src, String dest, Set<String> vis, Map<String, Map<String, Double>> graph, double product){
        if(src.equals(dest)) return product;
        vis.add(src);
        for(String nei: graph.get(src).keySet()){
            if(vis.contains(nei)) continue;
            double ans = dfs(nei, dest, vis, graph, product * graph.get(src).get(nei));
            if(ans != -1.0) return ans;
        }
        return -1;
    }
}