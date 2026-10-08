import array.ArraySearchMenu;

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

        int choice;
        do {
            System.out.println("\n========================================");
            System.out.println(" Data Structure & Graph Performance Analyzer");
            System.out.println("========================================");
            System.out.println("1. Array Operations");
            System.out.println("5. Searching Operations");
            System.out.println("9. Exit");
            choice = readInt(scanner, "Choose an option: ");

            switch (choice) {
                case 1 -> menu.arrayMenu();
                case 5 -> menu.searchMenu();
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
}
