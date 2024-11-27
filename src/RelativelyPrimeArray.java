public class RelativelyPrimeArray {
    public static void main(String[] args) {
        // First step is to get the input number (n) from the command-line argument
        int n = Integer.parseInt(args[0]); // This is to convert the first argument to an integer

        // Next step, create an (n+1)-by-(n+1) Boolean array
        boolean[][] rpa = new boolean[n + 1][n + 1];

        // Third step, fill the array to determine if each pair of numbers is relatively prime
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (gcd(i, j) == 1) { // to check if the greatest common divisor is 1
                    rpa[i][j] = true; // if they are relatively prime
                } else {
                    rpa[i][j] = false; // if they are not relatively prime
                }
            }
        }

        // Fourth step, print out the table header (numbers 1 to n)
        System.out.print("   "); // the initial spacing for alignment
        for (int j = 1; j <= n; j++) {
            System.out.print(j + " "); // to print column headers
        }
        System.out.println();

        // Fifth step, print the table rows
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " "); // to print the row header
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    System.out.print("  "); // You have to leave a blank space for diagonal
                } else {
                    System.out.print((rpa[i][j] ? "T " : "F ")); // T for true, F for false
                }
            }
            System.out.println(); // Moves to the next line
        }
    }

    // The Helper Function to calculate the greatest common divisor
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
