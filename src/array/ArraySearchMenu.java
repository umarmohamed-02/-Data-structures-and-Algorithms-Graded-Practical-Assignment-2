package array;

import search.SearchOps;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Console menus for array operations and searching.
 * All input is validated — letters, out-of-range choices, empty/full array.
 */
public class ArraySearchMenu {

    private final ArrayOps array;
    private final Scanner scanner;

    public ArraySearchMenu(Scanner scanner) {
        this.scanner = scanner;
        this.array = new ArrayOps();
    }

    // =====================================================================
    //  ARRAY MENU
    // =====================================================================
    public void arrayMenu() {
        int choice;
        do {
            System.out.println("\n===== Array Operations =====");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            choice = readInt("Choose an option: ");

            switch (choice) {
                case 1 -> handleInsert();
                case 2 -> handleDelete();
                case 3 -> handleSearch();
                case 4 -> array.display();
                case 5 -> System.out.println("Returning to Main Menu...");
                default -> System.out.println("Invalid option. Please enter 1-5.");
            }
        } while (choice != 5);
    }

    // =====================================================================
    //  SEARCH MENU
    // =====================================================================
    public void searchMenu() {
        int choice;
        do {
            System.out.println("\n===== Searching Operations =====");
            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search (array will be sorted first)");
            System.out.println("3. Compare Linear vs Binary Search");
            System.out.println("4. Return to Main Menu");
            choice = readInt("Choose an option: ");

            switch (choice) {
                case 1 -> handleLinearSearch();
                case 2 -> handleBinarySearch();
                case 3 -> handleCompare();
                case 4 -> System.out.println("Returning to Main Menu...");
                default -> System.out.println("Invalid option. Please enter 1-4.");
            }
        } while (choice != 4);
    }

    // =====================================================================
    //  DATA ACCESS (for the performance module)
    // =====================================================================

    /** Returns a copy of the current array contents. */
    public int[] getData() {
        return array.toArray();
    }

    // =====================================================================
    //  PRIVATE HELPERS — Array
    // =====================================================================

    private void handleInsert() {
        if (array.isFull()) {
            System.out.println("Array is full (capacity 100). Cannot insert.");
            return;
        }
        int value = readInt("Enter value to insert: ");
        array.insert(value);
        System.out.println(value + " inserted.");
        array.display();
    }

    private void handleDelete() {
        if (array.isEmpty()) {
            System.out.println("Array is empty. Nothing to delete.");
            return;
        }
        int value = readInt("Enter value to delete: ");
        if (array.delete(value)) {
            System.out.println(value + " deleted.");
        } else {
            System.out.println(value + " not found in the array.");
        }
        array.display();
    }

    private void handleSearch() {
        if (array.isEmpty()) {
            System.out.println("Array is empty. Nothing to search.");
            return;
        }
        int value = readInt("Enter value to search for: ");
        int pos = array.search(value);
        if (pos != -1) {
            System.out.println(value + " found at index " + pos + ".");
        } else {
            System.out.println(value + " not found.");
        }
    }

    // =====================================================================
    //  PRIVATE HELPERS — Search
    // =====================================================================

    private void handleLinearSearch() {
        if (array.isEmpty()) {
            System.out.println("Array is empty. Insert elements first.");
            return;
        }
        int target = readInt("Enter value to search for: ");
        int[] arr = array.toArray();
        SearchOps.Result r = SearchOps.linearSearch(arr, target);
        System.out.println("Linear Search: " + r);
    }

    private void handleBinarySearch() {
        if (array.isEmpty()) {
            System.out.println("Array is empty. Insert elements first.");
            return;
        }
        int target = readInt("Enter value to search for: ");
        int[] arr = array.toArray();

        // sort a copy so the original array order is not changed
        Arrays.sort(arr);
        System.out.println("(Array sorted for binary search: " + Arrays.toString(arr) + ")");

        SearchOps.Result r = SearchOps.binarySearch(arr, target);
        System.out.println("Binary Search: " + r);
    }

    private void handleCompare() {
        if (array.isEmpty()) {
            System.out.println("Array is empty. Insert elements first.");
            return;
        }
        int target = readInt("Enter value to search for: ");
        int[] original = array.toArray();
        int[] sorted   = array.toArray();
        Arrays.sort(sorted);

        SearchOps.Result lin = SearchOps.linearSearch(original, target);
        SearchOps.Result bin = SearchOps.binarySearch(sorted, target);

        System.out.println("\n--- Comparison ---");
        System.out.println("Linear Search : " + lin);
        System.out.println("Binary Search : " + bin);
        System.out.println();
        System.out.println("Complexity note:");
        System.out.println("  Linear Search is O(n) — it may check every element.");
        System.out.println("  Binary Search is O(log n) — it halves the search space each step.");
        System.out.println("  Binary search needs a sorted array; linear search does not.");
    }

    // =====================================================================
    //  INPUT VALIDATION
    // =====================================================================

    /** Keeps asking until the user enters a valid integer. */
    private int readInt(String prompt) {
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
