import array.ArraySearchMenu;
<<<<<< feature/graph-integration
import graph.Graph;
======
import linkedlist.LinkedList;
>>>>>> main

import java.util.Scanner;

/**
 * Main console application for the Data Structure & Graph Performance Analyzer.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArraySearchMenu menu = new ArraySearchMenu(scanner);
<<<<<< feature/graph-integration
        Graph graph = new Graph();
======
        LinkedList linkedList = new LinkedList();
>>>>>> main

        int choice;

        do {
            System.out.println("\n========================================");
            System.out.println(" Data Structure & Graph Performance Analyzer");
            System.out.println("========================================");
            System.out.println("1. Array Operations");
            System.out.println("4. Linked List Operations");
            System.out.println("5. Searching Operations");
            System.out.println("6. Graph Operations");
            System.out.println("9. Exit");

            choice = readInt(scanner, "Choose an option: ");

            switch (choice) {
                case 1 -> menu.arrayMenu();

                case 4 -> linkedListMenu(scanner, linkedList);

                case 5 -> menu.searchMenu();
<<<<<< feature/graph-integration
                case 6 -> graphMenu(graph, scanner);
======

>>>>>> main
                case 9 -> System.out.println("Goodbye!");

                default ->
                    System.out.println("Invalid option. Please enter 1, 4, 5, or 9.");
            }

        } while (choice != 9);

        scanner.close();
    }

    /**
     * Linked List submenu.
     */
    private static void linkedListMenu(Scanner scanner, LinkedList list) {

        int choice;

        do {
            System.out.println("\n------------ LINKED LIST OPERATIONS ------------");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Display");
            System.out.println("5. Display Size");
            System.out.println("6. Check Empty");
            System.out.println("7. Return to Main Menu");

            choice = readInt(scanner, "Choose an option: ");

            switch (choice) {

                case 1 -> {
                    int value = readInt(scanner, "Enter value to insert: ");
                    list.insert(value);
                    System.out.println("Value inserted successfully.");
                }

                case 2 -> {
                    int value = readInt(scanner, "Enter value to delete: ");

                    if (list.delete(value)) {
                        System.out.println("Value deleted successfully.");
                    } else {
                        System.out.println("Value not found.");
                    }
                }

                case 3 -> {
                    int value = readInt(scanner, "Enter value to search: ");
                    int position = list.search(value);

                    if (position != -1) {
                        System.out.println(
                            value + " found at index " + position
                        );
                    } else {
                        System.out.println("Value not found.");
                    }
                }

                case 4 -> list.display();

                case 5 ->
                    System.out.println("List size: " + list.getSize());

                case 6 ->
                    System.out.println("Is list empty? " + list.isEmpty());

                case 7 ->
                    System.out.println("Returning to Main Menu...");

                default ->
                    System.out.println(
                        "Invalid option. Please enter 1 to 7."
                    );
            }

        } while (choice != 7);
    }

    /**
     * Reads a valid integer from the user.
     */
    private static int readInt(Scanner scanner, String prompt) {

        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();

            try {
                return Integer.parseInt(line);

            } catch (NumberFormatException e) {
                System.out.println(
                    "Invalid input. Please enter a whole number."
                );
            }
        }
    }
<<<<<< feature/graph-integration

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
======
}
>>>>>> main
