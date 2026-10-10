
package stack.stackqueue;

import java.util.LinkedList;

public class MyQueue {
    private final LinkedList<Integer> items = new LinkedList<>();

    // Add an item to the rear of the queue
    public void enqueue(int value) {
        items.addLast(value);
        System.out.println(value + " added to the queue.");
    }

    // Remove the item at the front
    public void dequeue() {
        if (items.isEmpty()) {
            System.out.println("Queue is empty. Nothing to dequeue.");
            return;
        }

        int value = items.removeFirst();
        System.out.println("Removed: " + value);
    }

    // View the front item without removing it
    public void front() {
        if (items.isEmpty()) {
            System.out.println("Queue is empty. Nothing to view.");
            return;
        }

        System.out.println("Front item: " + items.getFirst());
    }

    // Display items from front to rear
    public void display() {
        if (items.isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.println("Queue (front to rear): " + items);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int size() {
        return items.size();
    }
}
