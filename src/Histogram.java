package introcs.JavaClass;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;

public class Histogram {
    public static void main(String[] args) {
        // Read the first line for n, and the range boundaries, left and right
        int n = StdIn.readInt();      // Number of intervals
        int left = StdIn.readInt();  // Left boundary
        int right = StdIn.readInt(); // Right boundary

        // Create an array to store the count of numbers in each interval
        int[] counts = new int[n];
        double intervalWidth = (right - left) * 1.0 / n; // Calculates the interval size

        // Read all remaining numbers from input
        while (!StdIn.isEmpty()) {
            int value = StdIn.readInt();

            // Check which interval the value falls into
            if (value >= left && value < right) {
                int index = (int) ((value - left) / intervalWidth);
                counts[index]++;
            }
        }

        // Configures the drawing area. The X-axis spans from left to right, and the Y-axis goes from 0 to the maximum count + 1
        StdDraw.setXscale(left, right);
        StdDraw.setYscale(0, getMax(counts) + 1); // Y-axis up to max count + some padding
        StdDraw.setPenColor(StdDraw.BLUE);

        // Plot out the histogram
        for (int i = 0; i < n; i++) {
            double x = left + (i + 0.5) * intervalWidth; // Center of the rectangle
            double y = counts[i] / 2.0; // Half the height
            double halfWidth = intervalWidth / 2.0; // Half the width
            double halfHeight = counts[i] / 2.0; // Half the height
            StdDraw.filledRectangle(x, y, halfWidth, halfHeight);
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