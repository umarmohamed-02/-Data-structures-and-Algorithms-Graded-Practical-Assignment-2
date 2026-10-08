package array;

import java.util.Arrays;

/**
 * Fixed-capacity integer array with insert, delete, search, sort, and display.
 * Capacity is 100. Elements are kept contiguous (shifts on insert/delete).
 */
public class ArrayOps {

    private static final int CAPACITY = 100;
    private int[] data;
    private int size; // number of elements currently stored

    public ArrayOps() {
        data = new int[CAPACITY];
        size = 0;
    }

    // --- core operations ------------------------------------------------

    /** Appends value at the end. Returns false if array is full. */
    public boolean insert(int value) {
        if (isFull()) return false;
        data[size] = value;
        size++;
        return true;
    }

    /** Inserts value at the given index, shifting elements right. */
    public boolean insertAt(int index, int value) {
        if (isFull()) return false;
        if (index < 0 || index > size) return false; // allow index == size (append)
        // shift elements right from the end down to index
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        size++;
        return true;
    }

    /** Deletes the first occurrence of value, shifting elements left. */
    public boolean delete(int value) {
        int pos = search(value);
        if (pos == -1) return false; // not found
        // shift elements left
        for (int i = pos; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return true;
    }

    /** Returns the index of value, or -1 if not found. */
    public int search(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) return i;
        }
        return -1;
    }

    /** Sorts the array in ascending order using Arrays.sort. */
    public void sort() {
        Arrays.sort(data, 0, size);
    }

    // --- accessors -------------------------------------------------------

    /** Returns a copy of the current elements (safe for outside use). */
    public int[] toArray() {
        return Arrays.copyOf(data, size);
    }

    /** Prints all elements to the console. */
    public void display() {
        if (isEmpty()) {
            System.out.println("Array is empty.");
            return;
        }
        System.out.print("Array [" + size + " element(s)]: ");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i]);
            if (i < size - 1) System.out.print(", ");
        }
        System.out.println();
    }

    public boolean isEmpty() { return size == 0; }
    public boolean isFull()  { return size == CAPACITY; }
    public int getSize()     { return size; }
}
