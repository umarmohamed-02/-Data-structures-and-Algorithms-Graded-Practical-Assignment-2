package graph;

import java.util.*;

/**
 * Graph implementation using an adjacency list.
 * Supports adding vertices, adding edges, displaying the graph,
 * BFS traversal and DFS traversal with step counting.
 */
public class Graph {

    // Adjacency list:
    // Each vertex has a list of vertices connected to it.
    private final Map<String, List<String>> adjacencyList;

    public Graph() {
        adjacencyList = new LinkedHashMap<>();
    }

    // ============================================================
    // ADD VERTEX
    // ============================================================

    /**
     * Adds a new vertex to the graph.
     * Returns false if the vertex already exists.
     */
    public boolean addVertex(String vertex) {
        if (vertex == null || vertex.trim().isEmpty()) {
            return false;
        }

        vertex = vertex.trim();

        if (adjacencyList.containsKey(vertex)) {
            return false;
        }

        adjacencyList.put(vertex, new ArrayList<>());
        return true;
    }

    // ============================================================
    // ADD EDGE
    // ============================================================

    /**
     * Adds an undirected edge between two existing vertices.
     * Returns false if either vertex does not exist or the edge
     * already exists.
     */
    public boolean addEdge(String source, String destination) {

        if (source == null || destination == null) {
            return false;
        }

        source = source.trim();
        destination = destination.trim();

        if (!adjacencyList.containsKey(source)
                || !adjacencyList.containsKey(destination)) {
            return false;
        }

        if (source.equals(destination)) {
            return false;
        }

        if (adjacencyList.get(source).contains(destination)) {
            return false;
        }

        // Because this is an undirected graph,
        // add the connection in both directions.
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);

        return true;
    }

    // ============================================================
    // DISPLAY GRAPH
    // ============================================================

    /**
     * Displays every vertex and its connected vertices.
     */
    public void displayGraph() {

        if (adjacencyList.isEmpty()) {
            System.out.println("Graph is empty.");
            return;
        }

        System.out.println("\n===== Graph =====");

        for (Map.Entry<String, List<String>> entry
                : adjacencyList.entrySet()) {

            System.out.print(entry.getKey() + " -> ");

            List<String> neighbours = entry.getValue();

            if (neighbours.isEmpty()) {
                System.out.println("No connections");
            } else {
                System.out.println(String.join(", ", neighbours));
            }
        }
    }

    // ============================================================
    // BFS
    // ============================================================

    /**
     * Performs Breadth-First Search from the given starting vertex.
     * BFS uses a Queue and visits vertices level by level.
     *
     * Returns the number of steps performed.
     */
    public int bfs(String startVertex) {

        if (!adjacencyList.containsKey(startVertex)) {
            System.out.println("Starting vertex not found.");
            return 0;
        }

        Set<String> visited = new LinkedHashSet<>();
        Queue<String> queue = new LinkedList<>();

        int steps = 0;

        visited.add(startVertex);
        queue.offer(startVertex);

        System.out.println("\n===== BFS Traversal =====");
        System.out.print("Traversal: ");

        while (!queue.isEmpty()) {

            String current = queue.poll();

            steps++;

            System.out.print(current);

            if (!queue.isEmpty()) {
                System.out.print(" -> ");
            }

            for (String neighbour : adjacencyList.get(current)) {

                steps++;

                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.offer(neighbour);
                }
            }
        }

        System.out.println();
        System.out.println("BFS Steps: " + steps);

        return steps;
    }

    // ============================================================
    // DFS
    // ============================================================

    /**
     * Performs Depth-First Search from the given starting vertex.
     * DFS uses a Stack and explores as deeply as possible first.
     *
     * Returns the number of steps performed.
     */
    public int dfs(String startVertex) {

        if (!adjacencyList.containsKey(startVertex)) {
            System.out.println("Starting vertex not found.");
            return 0;
        }

        Set<String> visited = new LinkedHashSet<>();
        Stack<String> stack = new Stack<>();

        int steps = 0;

        stack.push(startVertex);

        System.out.println("\n===== DFS Traversal =====");
        System.out.print("Traversal: ");

        while (!stack.isEmpty()) {

            String current = stack.pop();

            steps++;

            if (visited.contains(current)) {
                continue;
            }

            visited.add(current);

            System.out.print(current);

            boolean hasNext = false;

            for (String neighbour : adjacencyList.get(current)) {

                steps++;

                if (!visited.contains(neighbour)) {
                    stack.push(neighbour);
                    hasNext = true;
                }
            }

            if (hasNext) {
                System.out.print(" -> ");
            }
        }

        System.out.println();
        System.out.println("DFS Steps: " + steps);

        return steps;
    }

    // ============================================================
    // CHECK VERTEX
    // ============================================================

    /**
     * Checks whether a vertex exists in the graph.
     */
    public boolean containsVertex(String vertex) {
        return vertex != null && adjacencyList.containsKey(vertex.trim());
    }

    // ============================================================
    // GET VERTEX COUNT
    // ============================================================

    /**
     * Returns the number of vertices in the graph.
     */
    public int getVertexCount() {
        return adjacencyList.size();
    }

    // ============================================================
    // GET EDGE COUNT
    // ============================================================

    /**
     * Returns the number of undirected edges in the graph.
     */
    public int getEdgeCount() {

        int totalConnections = 0;

        for (List<String> neighbours : adjacencyList.values()) {
            totalConnections += neighbours.size();
        }

        // Each undirected edge is stored twice.
        return totalConnections / 2;
    }
}
