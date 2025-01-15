package introcs.JavaClass;

import java.util.ArrayList;
import java.util.List;

public class Hamming {
    public static void main(String[] args) {
        // Read the input: Hamming distance k and the bit string s
        int k = Integer.parseInt(args[0]);
        String s = args[1];
        int n = s.length();

        // Validate the input string
        if (!s.matches("[01]+")) {
            System.out.println("Error: The input bit string must contain only 0s and 1s.");
            return;
        }

        // Generate all possible bit strings of length n
        List<String> result = new ArrayList<>();
        generateBitStrings("", n, k, s, result); // Calls the recursive method to generate all possible bit strings and check their Hamming distance.

        // Print the result by looping through the result list and printing each valid bit string.
        for (String bitString : result) {
            System.out.println(bitString);
        }
    }

    private static void generateBitStrings(String current, int n, int k, String s, List<String> result) {
        if (current.length() == n) {
            // Check if the Hamming distance is equal to k. If the distance equals k, the string is added to result.
            if (getHammingDistance(current, s) == k) {
                result.add(current);
            }
            return;
        }

        // Two recursive calls add either 0 or 1 to current and continue building the bit string until its length matches n.
        generateBitStrings(current + "0", n, k, s, result);
        generateBitStrings(current + "1", n, k, s, result);
    }

    // Loops through each bit of strings a and b
    private static int getHammingDistance(String a, String b) {
        int distance = 0; // Increments distance for each position where the bits differ.
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                distance++;
            }
        }
        return distance; //Returns the total Hamming distance.
    }
}