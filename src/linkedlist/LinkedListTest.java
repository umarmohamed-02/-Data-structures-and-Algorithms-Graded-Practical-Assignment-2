package linkedlist;

public class LinkedListTest {

    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        System.out.println("=== INSERT TEST ===");
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.display();

        System.out.println("\n=== SEARCH TEST ===");
        int position = list.search(20);

        if (position != -1) {
            System.out.println("20 found at index " + position);
        } else {
            System.out.println("20 not found");
        }

        System.out.println("\n=== DELETE TEST ===");
        if (list.delete(20)) {
            System.out.println("20 deleted successfully");
        } else {
            System.out.println("20 not found");
        }

        list.display();

        System.out.println("\n=== SIZE TEST ===");
        System.out.println("List size: " + list.getSize());

        System.out.println("\n=== EMPTY TEST ===");
        System.out.println("Is list empty? " + list.isEmpty());
    }
}