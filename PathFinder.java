import java.util.*;

public class PathFinder {
    private List<Integer>[] adjList;
    private boolean[] visited;
    private List<Integer> path;
    private List<List<Integer>> cycles;

    public PathFinder(GraphQ2 graph) {
        this.adjList = graph.getAdjList();
    }

    public List<Integer> findSmallestCycle(int start, int end) {
        visited = new boolean[adjList.length];
        path = new ArrayList<>();
        cycles = new ArrayList<>();    // Method to find the smallest cycle that includes the destination city

     // Perform DFS traversal to find cycles 
        dfs(start, start, end);

        Collections.sort(cycles, Comparator.comparingInt(List::size)); // Sort cycles by size

        for (List<Integer> cycle : cycles) {
            if (cycle.contains(end)) {
                Collections.sort(cycle);
                return cycle;
            }
        }

        return new ArrayList<>(); // Return an empty list if no cycle including the destination city is found
    }

    private void dfs(int startNode, int currentNode, int end) {
        visited[currentNode] = true;             // Depth-first search to explore paths
        path.add(currentNode);

        for (int adj : adjList[currentNode]) {
            if (adj == end && path.size() > 2) {
                List<Integer> cycle = new ArrayList<>(path);
                cycles.add(cycle);
            } else if (!visited[adj]) {
                dfs(startNode, adj, end);
            }
        }

        visited[currentNode] = false;
        path.remove(path.size() - 1);
    }
}