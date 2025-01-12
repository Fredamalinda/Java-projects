import java.util.Scanner;

public class LineNum {
    // We need to implement the Queue class from the book, outside of the main method
    private static class Queue {
        private Node first, last;
        private int size;

        private class Node {
            String item;
            Node next;
        }

        // isEmpty() Checks if the queue is empty
        public boolean isEmpty() {
            return first == null;
        }

        // enqueue(String item) Adds a string to the end of the queue
        public void enqueue(String item) {
            Node oldLast = last;
            last = new Node();
            last.item = item;
            last.next = null;
            if (isEmpty()) {
                first = last;
            } else {
                oldLast.next = last;
            }
            size++;
        }

        // dequeue() Removes and returns the first string from the queue
        public String dequeue() {
            if (isEmpty()) throw new RuntimeException("Queue underflow");
            String item = first.item;
            first = first.next;
            if (isEmpty()) last = null;
            size--;
            return item;
        }

        public int size() {
            return size;
        }
    }
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java LineNum <n>");
            return;
        }

        int n = Integer.parseInt(args[0]); // Parse n from the arguments

        // Creating a Queue and read the input
        Queue queue = new Queue();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the strings (press CTRL+D to finish):");
        while (scanner.hasNextLine()) {
            queue.enqueue(scanner.nextLine());
        }

        // Dequeue strings until the nth one
        String result = null;
        for (int i = 0; i < n; i++) {
            if (queue.isEmpty()) {
                System.out.println("Not enough strings are provided.");
                return;
            }
            result = queue.dequeue();
        }
        // Printing the nth string
        System.out.println(n + " from the first is " + result);
    }
}