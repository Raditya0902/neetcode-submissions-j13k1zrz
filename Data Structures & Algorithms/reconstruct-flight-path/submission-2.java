class Solution {
    Map<String, PriorityQueue<String>> graph = new HashMap<>();
    List<String> route = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> t: tickets){
            graph.computeIfAbsent(t.get(0), k-> new PriorityQueue<>()).offer(t.get(1));
        }
        dfs("JFK");
        Collections.reverse(route);
        return route;
    }

    void dfs(String airport){
        PriorityQueue<String> dests = graph.get(airport);
        while(dests != null && !dests.isEmpty()){
            dfs(dests.poll());
        }
        route.add(airport);
    }
}
