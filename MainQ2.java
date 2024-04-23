import java.util.List;
import java.util.Scanner;

public class MainQ2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // Number of cities
        int M = scanner.nextInt(); // Number of connections

        GraphQ2 graph = new GraphQ2(N);
        for (int i = 0; i < M; i++) {
            int U = scanner.nextInt();   // Add connections to the graph
            int V = scanner.nextInt();
            graph.addEdge(U, V);
        }

        int start = scanner.nextInt(); // Starting city
        int end = scanner.nextInt(); // Destination city

        PathFinder pathFinder = new PathFinder(graph); // Find the smallest cycle that includes the destination city
        List<Integer> path = pathFinder.findSmallestCycle(start, end);

        BagQ2<Integer> pathBag = new BagQ2<>();
        path.forEach(pathBag::add);

        for (int i = 0; i < pathBag.size(); i++) {
            try {
                System.out.print(pathBag.get(i) + " "); // Print the path
            } catch (IndexOutOfBoundsException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }
}
