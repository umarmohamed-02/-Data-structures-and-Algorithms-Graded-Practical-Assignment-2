package stack;

import java.util.ArrayList;

public class MyStack {
    private final ArrayList<Integer> items = new ArrayList<>();

    // Add an item to the top of the stack
    public void push(int value) {
        items.add(value);
        System.out.println(value + " pushed onto the stack.");
    }

    // Remove the top item
    public void pop() {
        if (items.isEmpty()) {
            System.out.println("Stack is empty. Nothing to pop.");
            return;
        }

        int value = items.remove(items.size() - 1);
        System.out.println("Popped: " + value);
    }

    // View the top item without removing it
    public void peek() {
        if (items.isEmpty()) {
            System.out.println("Stack is empty. Nothing to peek.");
            return;
        }

        System.out.println("Top item: " + items.get(items.size() - 1));
    }

    // Display items from top to bottom
    public void display() {
        if (items.isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.println("Stack (top to bottom):");
        for (int i = items.size() - 1; i >= 0; i--) {
            System.out.println(items.get(i));
        }
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int size() {
        return items.size();
    }
}
