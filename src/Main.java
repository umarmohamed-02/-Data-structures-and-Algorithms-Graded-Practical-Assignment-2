import array.ArraySearchMenu;
import linkedlist.LinkedList;

import java.util.Scanner;

/**
 * Main console application for the Data Structure & Graph Performance Analyzer.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArraySearchMenu menu = new ArraySearchMenu(scanner);
        LinkedList linkedList = new LinkedList();

        int choice;

        do {
            System.out.println("\n========================================");
            System.out.println(" Data Structure & Graph Performance Analyzer");
            System.out.println("========================================");
            System.out.println("1. Array Operations");
            System.out.println("4. Linked List Operations");
            System.out.println("5. Searching Operations");
            System.out.println("9. Exit");

            choice = readInt(scanner, "Choose an option: ");

            switch (choice) {
                case 1 -> menu.arrayMenu();

                case 4 -> linkedListMenu(scanner, linkedList);

                case 5 -> menu.searchMenu();

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
}