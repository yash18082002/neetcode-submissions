class Solution {
    Map<String, PriorityQueue<String>> graph = new HashMap<>();
    LinkedList<String> route = new LinkedList<>();

    private void dfs(String airport) {
        PriorityQueue<String> dest = graph.get(airport);
        while (dest != null && !dest.isEmpty()) {
            dfs(dest.poll());
        }
        route.addFirst(airport);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> t : tickets) {
            String from = t.get(0);
            PriorityQueue<String> dests = graph.get(from);
            if (dests == null) {
                dests = new PriorityQueue<>();
                graph.put(from, dests);
            }
            dests.offer(t.get(1));
        }
        dfs("JFK");
        return route;
    }
}
