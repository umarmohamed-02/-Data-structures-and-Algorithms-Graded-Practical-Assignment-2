package search;

/**
 * Linear and binary search with step counting and timing.
 * Each search returns a SearchOps.Result object.
 */
public class SearchOps {

    /** Holds the outcome of a search: index, comparison count, and nanoseconds. */
    public static class Result {
        public final int index;  // -1 if not found
        public final int steps;  // number of comparisons made
        public final long nanos; // elapsed time in nanoseconds

        public Result(int index, int steps, long nanos) {
            this.index = index;
            this.steps = steps;
            this.nanos = nanos;
        }

        @Override
        public String toString() {
            String status = (index == -1) ? "Not found" : "Found at index " + index;
            return status + " | Comparisons: " + steps + " | Time: " + nanos + " ns";
        }
    }

    // --- searches --------------------------------------------------------

    /** Scans every element from left to right. Works on any array. */
    public static Result linearSearch(int[] arr, int target) {
        long start = System.nanoTime();
        int steps = 0;
        for (int i = 0; i < arr.length; i++) {
            steps++;
            if (arr[i] == target) {
                long elapsed = System.nanoTime() - start;
                return new Result(i, steps, elapsed);
            }
        }
        long elapsed = System.nanoTime() - start;
        return new Result(-1, steps, elapsed);
    }

    /** Classic binary search. The array MUST be sorted first. */
    public static Result binarySearch(int[] arr, int target) {
        long start = System.nanoTime();
        int steps = 0;
        int lo = 0, hi = arr.length - 1;

        while (lo <= hi) {
            steps++;
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == target) {
                long elapsed = System.nanoTime() - start;
                return new Result(mid, steps, elapsed);
            } else if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        long elapsed = System.nanoTime() - start;
        return new Result(-1, steps, elapsed);
    }

    // --- helper ----------------------------------------------------------

    /** Returns true if the array is sorted in non-decreasing order. */
    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) return false;
        }
        return true;
    }
}
