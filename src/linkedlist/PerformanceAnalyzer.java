package linkedlist;

import array.ArrayOps;

public class PerformanceAnalyzer {

    // Compare insertion performance.
    private static void compareInsert() {
        ArrayOps array = new ArrayOps();
        LinkedList list = new LinkedList();

        long start = System.nanoTime();
        array.insert(100);
        long arrayTime = System.nanoTime() - start;

        start = System.nanoTime();
        list.insert(100);
        long listTime = System.nanoTime() - start;

        System.out.printf(
            "%-12s %-15s %-10d %-15d%n",
            "Insert", "Array", 1, arrayTime
        );

        System.out.printf(
            "%-12s %-15s %-10d %-15d%n",
            "Insert", "Linked List", 1, listTime
        );
    }

    // Compare search performance.
    private static void compareSearch() {
        ArrayOps array = new ArrayOps();
        LinkedList list = new LinkedList();

        for (int i = 1; i <= 100; i++) {
            array.insert(i);
            list.insert(i);
        }

        int target = 100;

        int arraySteps = 0;
        long start = System.nanoTime();

        for (int value : array.toArray()) {
            arraySteps++;

            if (value == target) {
                break;
            }
        }

        long arrayTime = System.nanoTime() - start;

        start = System.nanoTime();
        int listIndex = list.search(target);
        long listTime = System.nanoTime() - start;

        int listSteps = listIndex + 1;

        System.out.printf(
            "%-12s %-15s %-10d %-15d%n",
            "Search", "Array", arraySteps, arrayTime
        );

        System.out.printf(
            "%-12s %-15s %-10d %-15d%n",
            "Search", "Linked List", listSteps, listTime
        );
    }

    // Compare deletion performance.
    private static void compareDelete() {
        ArrayOps array = new ArrayOps();
        LinkedList list = new LinkedList();

        for (int i = 1; i <= 100; i++) {
            array.insert(i);
            list.insert(i);
        }

        int target = 50;

        // Array deletion:
        // 50 comparisons to find the value + 50 shifts after deletion.
        long start = System.nanoTime();
        array.delete(target);
        long arrayTime = System.nanoTime() - start;

        // Linked list deletion:
        // 49 checks are needed to reach the node before value 50.
        start = System.nanoTime();
        list.delete(target);
        long listTime = System.nanoTime() - start;

        System.out.printf(
            "%-12s %-15s %-10d %-15d%n",
            "Delete", "Array", 100, arrayTime
        );

        System.out.printf(
            "%-12s %-15s %-10d %-15d%n",
            "Delete", "Linked List", 49, listTime
        );
    }

    // Display all performance results.
    public static void displayAllResults() {
        System.out.println("\n========== PERFORMANCE COMPARISON ==========");

        System.out.printf(
            "%-12s %-15s %-10s %-15s%n",
            "Operation", "Structure", "Steps", "Time (ns)"
        );

        System.out.println(
            "------------------------------------------------------"
        );

        compareInsert();
        compareSearch();
        compareDelete();

        System.out.println(
            "======================================================"
        );
    }
}