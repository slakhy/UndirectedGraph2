import java.util.*;

public class GraphQ2 {
    private List<Integer>[] adjList;

    @SuppressWarnings("unchecked")
 // Constructor to initialize the graph with N cities
    public GraphQ2(int N) {
        adjList = new List[N + 1];
        for (int i = 1; i <= N; i++) {      
            adjList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int U, int V) {
        adjList[U].add(V);                 // Method to add an edge between two cities
        adjList[V].add(U);
    }

    public List<Integer>[] getAdjList() {
        return adjList;      // Getter method to access the adjacency list
    }
}
