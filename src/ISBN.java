public class ISBN {
    public static void main(String[] args) {
        // Check the input. Make sure exactly one argument is provided and that it's 9 digits long.
        if (args.length != 1 || args[0].length() != 9) {
            System.out.println("Please provide a single 9-digit integer.");
            return; // Exit the program if the input is invalid.
        }

        // Store the input string and prepare an array to hold individual digits.
        String input = args[0];
        int[] digits = new int[9];

        // Convert each character of the input string to an integer and store in the array.
        try {
            for (int i = 0; i < 9; i++) {
                digits[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please make sure all of the characters are digits.");
            return; // Exit the program if the input is incorrect.
        }

        // Calculate the checksum using the formula.
        int checksum = 0;
        for (int i = 0; i < 9; i++) {
            checksum += digits[i] * (10 - i);
        }
        int d10 = (11 - (checksum % 11)) % 11; // Check the 10th digit.

        // Construct the final ISBN, appending 'X' if d10 is 10.
        StringBuilder isbn = new StringBuilder(input);
        if (d10 == 10) {
            isbn.append('X');
        } else {
            isbn.append(d10);
        }

        // Finally we print the full 10-digit ISBN.
        System.out.println("The ISBN number is: " + isbn);
    }
}
