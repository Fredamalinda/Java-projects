import java.io.*;
import java.util.*;

public class SubGraph {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.out.println("Usage: java SubGraph <file> <vertices...>");
            return;
        }

        // Parse command-line arguments
        String filename = args[0];
        Set<String> subGraphVertices = new HashSet<>(Arrays.asList(Arrays.copyOfRange(args, 1, args.length)));

        // Create an adjacency list for the graph
        Map<String, List<String>> graph = new HashMap<>();

        // Read the input file and build the graph
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] vertices = line.split(" ");
            String v1 = vertices[0];
            String v2 = vertices[1];

            graph.putIfAbsent(v1, new ArrayList<>());
            graph.putIfAbsent(v2, new ArrayList<>());

            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        reader.close();

        // Print the full graph
        System.out.println("The graph is:");
        for (String vertex : graph.keySet()) {
            System.out.println(vertex + ": " + String.join(" ", graph.get(vertex)));
        }

        // Build the subgraph
        System.out.println("The subgraph is:");
        for (String vertex : subGraphVertices) {
            if (graph.containsKey(vertex)) {
                List<String> neighbors = graph.get(vertex);
                List<String> filteredNeighbors = new ArrayList<>();

                for (String neighbor : neighbors) {
                    if (subGraphVertices.contains(neighbor)) {
                        filteredNeighbors.add(neighbor);
                    }
                }

                System.out.println(vertex + ": " + String.join(" ", filteredNeighbors));
            }
        }
    }
}