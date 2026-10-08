import array.ArraySearchMenu;
import graph.Graph;

import java.util.Scanner;

/**
 * Temporary Main — tests Array and Searching modules only.
 * Menu numbers 1 and 5 match the final project layout;
 * other members will add options 2, 3, 4, 6, 7, 8.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArraySearchMenu menu = new ArraySearchMenu(scanner);
        Graph graph = new Graph();

        int choice;
        do {
            System.out.println("\n========================================");
            System.out.println(" Data Structure & Graph Performance Analyzer");
            System.out.println("========================================");
            System.out.println("1. Array Operations");
            System.out.println("5. Searching Operations");
            System.out.println("6. Graph Operations");
            System.out.println("9. Exit");
            choice = readInt(scanner, "Choose an option: ");

            switch (choice) {
                case 1 -> menu.arrayMenu();
                case 5 -> menu.searchMenu();
                case 6 -> graphMenu(graph, scanner);
                case 9 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid option. Please enter 1, 5, or 9.");
            }
        } while (choice != 9);

        scanner.close();
    }

    /** Reads a valid integer, re-prompting on bad input. */
    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a whole number.");
            }
        }
    }

    private static void graphMenu(Graph graph, Scanner scanner) {

    int choice;

    do {
        System.out.println("\n===== Graph Operations =====");
        System.out.println("1. Add Vertex");
        System.out.println("2. Add Edge");
        System.out.println("3. Display Graph");
        System.out.println("4. BFS Traversal");
        System.out.println("5. DFS Traversal");
        System.out.println("6. Return to Main Menu");

        choice = readInt(scanner, "Choose an option: ");

        switch (choice) {

            case 1 -> {
                System.out.print("Enter vertex name: ");
                String vertex = scanner.nextLine().trim();

                if (graph.addVertex(vertex)) {
                    System.out.println("Vertex added successfully.");
                } else {
                    System.out.println("Vertex could not be added. It may already exist or be empty.");
                }
            }

            case 2 -> {
                System.out.print("Enter source vertex: ");
                String source = scanner.nextLine().trim();

                System.out.print("Enter destination vertex: ");
                String destination = scanner.nextLine().trim();

                if (graph.addEdge(source, destination)) {
                    System.out.println("Edge added successfully.");
                } else {
                    System.out.println("Edge could not be added. Check that both vertices exist and the edge is not duplicated.");
                }
            }

            case 3 -> graph.displayGraph();

            case 4 -> {
                System.out.print("Enter starting vertex for BFS: ");
                String start = scanner.nextLine().trim();
                graph.bfs(start);
            }

            case 5 -> {
                System.out.print("Enter starting vertex for DFS: ");
                String start = scanner.nextLine().trim();
                graph.dfs(start);
            }

            case 6 -> System.out.println("Returning to Main Menu...");

            default -> System.out.println("Invalid option. Please enter 1-6.");
        }

    } while (choice != 6);
}

}
