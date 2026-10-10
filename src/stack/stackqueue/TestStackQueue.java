package stack.stackqueue;

import stack.MyStack;

public class TestStackQueue {
    public static void main(String[] args) {
        System.out.println("===== TESTING STACK =====");

        MyStack stack = new MyStack();
        stack.pop();       // Test empty stack
        stack.push(10);
        stack.push(20);
        stack.peek();
        stack.display();
        stack.pop();
        stack.display();

        System.out.println("\n===== TESTING QUEUE =====");

        MyQueue queue = new MyQueue();
        queue.dequeue();   // Test empty queue
        queue.enqueue(10);
        queue.enqueue(20);
        queue.front();
        queue.display();
        queue.dequeue();
        queue.display();
    }
}
