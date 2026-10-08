package linkedlist;

/**
 * Singly linked list implementation for integer values.
 * Supports insertion, deletion, searching, and displaying elements.
 */
public class LinkedList {

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    // Insert a value at the end of the linked list.
    public void insert(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        size++;
        
    }

    // Delete the first occurrence of a value.
    public boolean delete(int value) {
        if (head == null) {
            return false;
        }

        if (head.data == value) {
            head = head.next;
            size--;
            return true;
        }

        Node current = head;

        while (current.next != null) {
            if (current.next.data == value) {
                current.next = current.next.next;
                size--;
                return true;
            }

            current = current.next;
        }

        return false;
    }

    // Return the position of a value, or -1 if not found.
    public int search(int value) {
        Node current = head;
        int index = 0;

        while (current != null) {
            if (current.data == value) {
                return index;
            }

            current = current.next;
            index++;
        }

        return -1;
    }

    // Display every value in the linked list.
    public void display() {
        if (head == null) {
            System.out.println("Linked list is empty.");
            return;
        }

        Node current = head;

        System.out.print("Linked List: ");

        while (current != null) {
            System.out.print(current.data);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current = current.next;
        }

        System.out.println();
    }

    // Return the current number of elements.
    public int getSize() {
        return size;
    }

    // Check whether the list is empty.
    public boolean isEmpty() {
        return head == null;
    }
}