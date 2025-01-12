import java.util.Scanner;

public class LinkedStackOfStrings {
    private Node first = null; // Top of stack (the most recently added node)

    // Linked list node structure
    private class Node {
        String item;
        Node next;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return first == null;
    }

    // Push a string onto the stack
    public void push(String item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    // Pop a string from the stack
    public String pop() {
        if (isEmpty()) throw new RuntimeException("Stack underflow");
        String item = first.item;
        first = first.next;
        return item;
    }

    // Find if a string exists in the stack
    public boolean find(String key) {
        Node current = first;
        while (current != null) {
            if (current.item.equals(key)) {
                return true; // Found the string
            }
            current = current.next;
        }
        return false; // String not found
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java LinkedStackOfStrings <search_string>");
            return;
        }

        String searchString = args[0]; // The string to search for
        LinkedStackOfStrings stack = new LinkedStackOfStrings();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the strings (press CTRL+D to finish):");
        while (scanner.hasNextLine()) {
            stack.push(scanner.nextLine());
        }

        // Call find() and print the result
        if (stack.find(searchString)) {
            System.out.println(searchString + " exists in the linked stack.");
        } else {
            System.out.println(searchString + " does not exist in the linked stack.");
        }
    }
}