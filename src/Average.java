public class Average {
    public static void main(String[] args) {
        // put in the correct number of command-line arguments.
        if (args.length != 1) {
            System.out.println("Usage: java Average <number_of_entries>");
            return; // it will exit if no valid argument is provided
        }

        // Parse the number of entries from the command-line argument
        int numberOfEntries = Integer.parseInt(args[0]);

        // Write out what the user needs to do
        System.out.println("Please enter " + numberOfEntries + " lines, each containing a name followed by three integers.");

        // read input from the standard input
        String[] inputLines = new String[numberOfEntries];
        for (int i = 0; i < numberOfEntries; i++) {
            inputLines[i] = StdIn.readLine(); // Read each line using StdIn
        }

        // process each input line
        for (int i = 0; i < numberOfEntries; i++) {
            String[] tokens = inputLines[i].split(" "); // we will split the input line into parts
            String name = tokens[0];                   // first token is the name
            int num1 = Integer.parseInt(tokens[1]);    // second token is the first number
            int num2 = Integer.parseInt(tokens[2]);    // third token is the second number
            int num3 = Integer.parseInt(tokens[3]);    // fourth token is the third number

            //  now calculate the average
            double average = (num1 + num2 + num3) / 3.0;

            // finally print the result
            System.out.printf("%-10s %4d %4d %4d %8.2f%n", name, num1, num2, num3, average);
        }
    }
}
