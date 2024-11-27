public class Distribution100 {
    public static void main(String[] args) {
        // First step is to get the total count of numbers to process
        int totalNumbers = Integer.parseInt(args[0]); // the first argument is the count

        // Next step is to initialize the counters
        int countLessOrEqual50 = 0;
        int countGreaterThan50 = 0;

        // Third step, loop through the remaining arguments so it can process the numbers
        for (int i = 1; i <= totalNumbers; i++) {
            int number = Integer.parseInt(args[i]); // convert each argument to an integer
            if (number <= 50) {
                countLessOrEqual50++; // set the counter for numbers <= 50
            } else {
                countGreaterThan50++; // set the counter for numbers > 50
            }
        }

        // Lastly, print the results
        System.out.println(countLessOrEqual50 + " numbers entered are less than or equal to 50.");
        System.out.println(countGreaterThan50 + " numbers entered are greater than 50.");
    }
}
