class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> graph = new HashMap<>();
        for(List<String> t: tickets){
            graph.computeIfAbsent(t.get(0), k-> new PriorityQueue<>()).offer(t.get(1));
        }
        List<String> res = new ArrayList<>();
        dfs(graph, "JFK", res);
        Collections.reverse(res);
        return res;
    }

    void dfs(HashMap<String, PriorityQueue<String>> graph, String src, List<String> res){
        PriorityQueue<String> pq = graph.get(src);
        while(pq != null && !pq.isEmpty()){
            String dst = pq.poll();
            dfs(graph, dst, res);
        }
        res.add(src);
    }
}
