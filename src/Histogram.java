package introcs.JavaClass;

import edu.princeton.cs.algs4.StdDraw;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Histogram {
    public static void main(String[] args) {
        try {
            // Open the input file
            File inputFile = new File("data.txt");
            Scanner scanner = new Scanner(inputFile);

            // Read the first line for n, and the range boundaries, left and right
            int n = scanner.nextInt();      // Number of intervals
            int left = scanner.nextInt();  // Left boundary
            int right = scanner.nextInt(); // Right boundary

            // Create an array to store the count of numbers in each interval
            int[] counts = new int[n];
            double intervalWidth = (right - left) * 1.0 / n; // Calculates the interval size

            // Read all remaining numbers from the input file
            while (scanner.hasNextInt()) {
                int value = scanner.nextInt();

                // Check which interval the value falls into
                if (value >= left && value < right) {
                    int index = (int) ((value - left) / intervalWidth);
                    counts[index]++;
                }
            }
            scanner.close();

            // Configures the drawing area. The X-axis spans from left to right, and the Y-axis goes from 0 to the maximum count + 1
            StdDraw.setXscale(left, right);
            StdDraw.setYscale(0, getMax(counts) + 1); // Y-axis up to max count + some padding
            StdDraw.setPenColor(StdDraw.BLUE);

            // Plot out the histogram
            for (int i = 0; i < n; i++) {
                double x = left + (i + 0.5) * intervalWidth; // Center of the rectangle
                double y = counts[i] / 2.0;                 // Half the height
                double halfWidth = intervalWidth / 2.0;    // Half the width
                double halfHeight = counts[i] / 2.0;       // Half the height
                StdDraw.filledRectangle(x, y, halfWidth, halfHeight);
            }

        } catch (FileNotFoundException e) { // To make sure the data.txt file is in the root folder
            System.err.println("Error: File 'data.txt' not found. Make sure it is in the working directory.");
            e.printStackTrace();
        }
    }

    // Helper method to find the maximum value in an array
    private static int getMax(int[] array) {
        int max = array[0];
        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
}