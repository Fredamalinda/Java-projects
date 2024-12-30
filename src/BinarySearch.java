
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        // Check for proper command-line arguments
        if (args.length != 2) {
            System.out.println("Usage: java BinarySearch <input_file> <key>");
            return;
        }

        try {
            // Read the array from the input file
            File file = new File(args[0]);
            Scanner scanner = new Scanner(file);
            int[] array = scanner.tokens().mapToInt(Integer::parseInt).toArray();
            scanner.close();

            // Parse the search key from the second argument
            int key = Integer.parseInt(args[1]);

            // Perform the modified binary search
            int result = binarySearch(array, key);
            System.out.println(result);

        } catch (FileNotFoundException e) {
            System.out.println("Input file not found.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input format.");
        }
    }

    // Modified binary search method
    public static int binarySearch(int[] array, int key) {
        int lo = 0;
        int hi = array.length - 1;
        int result = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (array[mid] == key) {
                result = mid; // Found the key
                lo = mid + 1; // Search for a larger index
            } else if (array[mid] < key) {
                result = -(mid + 1); // Save the largest index where a[i] < key
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return result;
    }
}