package introcs.JavaClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class LookupMultipleNumber {
    public static void main(String[] args) throws Exception {
        // Ensure correct number of command-line arguments
        if (args.length < 2) {
            System.out.println("Usage: java LookupMultipleNumber <filename> <max_values> <keys...>");
            return;
        }

        // Parse the file and max values to print
        String filename = args[0];
        int maxValues = Integer.parseInt(args[1]);

        // Initialize a symbol table (HashMap) to store key-value pairs
        Map<String, Queue<String>> symbolTable = new HashMap<>();

        // Read file contents
        Scanner fileScanner = new Scanner(new File(filename));
        while (fileScanner.hasNextLine()) {
            String[] tokens = fileScanner.nextLine().split(",");
            String key = tokens[0]; // First token is the key
            Queue<String> values = new LinkedList<>(); // Use LinkedList to implement Queue

            // Add all values to the queue
            for (int i = 1; i < tokens.length; i++) {
                values.add(tokens[i]);
            }
            symbolTable.put(key, values);
        }
        fileScanner.close();

        // Process each key from command-line arguments
        for (int i = 2; i < args.length; i++) {
            String key = args[i];
            if (symbolTable.containsKey(key)) {
                System.out.print(key + ": ");
                Queue<String> values = symbolTable.get(key);

                // Print up to maxValues values for this key
                int count = 0;
                while (!values.isEmpty() && count < maxValues) {
                    System.out.print(values.poll() + " ");
                    count++;
                }
                System.out.println();
            } else {
                System.out.println(key + ": not found");
            }
        }
    }
}