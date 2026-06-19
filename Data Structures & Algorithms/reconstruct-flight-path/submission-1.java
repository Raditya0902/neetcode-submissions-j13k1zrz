class Solution {
    Map<String, PriorityQueue<String>> graph = new HashMap<>();
    List<String> route = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> ticket: tickets){
            graph.computeIfAbsent(ticket.get(0), k-> new PriorityQueue<>()).offer(ticket.get(1));
        }
        dfs("JFK");
        Collections.reverse(route);
        return route;
    }
    void dfs(String airport){
        PriorityQueue<String> destinations = graph.get(airport);
        while(destinations != null && !destinations.isEmpty()){
            String next = destinations.poll();
            dfs(next);
        }
        route.add(airport);
    }
}
