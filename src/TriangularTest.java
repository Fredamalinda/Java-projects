public class TriangularTest {
    // This will check the three sides of the triangle to make sure that the sum of two sides of the triangle will be greater than the third side.
    public static boolean isTriangular(int a, int b, int c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    // This is where you take the input and evaluate it with the isTriangular method
    public static void main(String[] args) {
        // Checking to see if the correct number of arguments are provided
        if (args.length != 3) {
            System.out.println("Please provide only three integer values.");
            return;
        }

        try {
            // The program will take 3 command-line arguments
            int side1 = Integer.parseInt(args[0]);
            int side2 = Integer.parseInt(args[1]);
            int side3 = Integer.parseInt(args[2]);

            // If the input is valid, then isTriangular will print out the result. If its not valid, then it will print this error message.
            System.out.println(isTriangular(side1, side2, side3));
        } catch (NumberFormatException e) {
            System.out.println("Please make sure all of your input is only integers.");
        }
    }
}
