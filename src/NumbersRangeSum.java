public class NumbersRangeSum {
    // This program will use the static recursive method to calculate the sum in a range
    public static int getSum(int start, int end) {
        if (start > end) {
            return 0; // This is the Base case, it terminates the recursion and prevents it from running indefinitely. When start becomes grater than the end, there's no numbers left in the range to add. So it returns 0
        }
        return start + getSum(start + 1, end);
    }

    // Main method to take the input and call the getSum method
    public static void main(String[] args) {
        // Check to see if the correct number of arguments are provided
        if (args.length != 2) {
            System.out.println("Please provide only two integer arguments.");
            return;
        }

        try {
            // The program will take 2 command-line arguments
            int start = Integer.parseInt(args[0]);
            int end = Integer.parseInt(args[1]);

            // Here we will validate the inputs to make sure they are natural numbers and in a valid range.
            if (start <= 0 || end <= 0) {
                System.out.println("Please ensure both numbers are natural numbers (1 or greater).");
                return;
            }

            if (start > end) {
                System.out.println("The start number should be less than or equal to the end number.");
                return;
            }

            // Call getSum and print the result
            int sum = getSum(start, end);
            System.out.println("The sum of natural numbers in range [" + start + "," + end + "] is " + sum + ".");
        } catch (NumberFormatException e) {
            System.out.println("Please make sure both inputs are integers.");
        }
    }
}
