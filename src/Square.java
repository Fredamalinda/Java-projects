package introcs.JavaClass;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;

public class Square {
    private final double x; // x-coordinate of the upper-left corner
    private final double y; // y-coordinate of the upper-left corner
    private final double length; // side length of the square

    // Constructor will initialize the square with the provided x, y, and length.
    public Square(double x, double y, double length) {
        this.x = x;
        this.y = y;
        this.length = length;
    }

    // Calculates and returns the area of the square
    public double area() {
        return length * length;
    }

    // Calculates and returns the perimeter of the square
    public double perimeter() {
        return 4 * length;
    }

    // Compares boundaries to check if one square is completely left/right or above/below the other, and returns false if there is no overlap. Otherwise, it will return as true.
    public boolean intersects(Square b) {
        // Check if one square is to the left or right of the other
        if (this.x + this.length < b.x || b.x + b.length < this.x) return false;
        // Check if one square is above or below the other
        if (this.y - this.length > b.y || b.y - b.length > this.y) return false;
        return true;
    }

    // Checks if the square completely contains another square
    public boolean contains(Square b) {
        return this.x <= b.x &&
                this.y >= b.y &&
                this.x + this.length >= b.x + b.length &&
                this.y - this.length <= b.y - b.length;
    }

    // Draws the square on the standard drawing window
    public void draw() {
        double centerX = x + length / 2.0; // Center x-coordinate
        double centerY = y - length / 2.0; // Center y-coordinate
        StdDraw.square(centerX, centerY, length / 2.0);
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        // Reads the first square’s properties (x, y, length) from command line arguments.
        double x1 = Double.parseDouble(args[0]);
        double y1 = Double.parseDouble(args[1]);
        double length1 = Double.parseDouble(args[2]);

        Square square1 = new Square(x1, y1, length1); // Creates the first square object with the parsed arguments.

        // Prints the area and perimeter of the first square
        System.out.printf("The area is %.2f%n", square1.area());
        System.out.printf("The perimeter is %.2f%n", square1.perimeter());

        // Prompts the user to input the second square’s properties and reads them using StdIn.
        System.out.println("Enter the upper-left coordinates and the length of a square: ");
        double x2 = StdIn.readDouble();
        double y2 = StdIn.readDouble();
        double length2 = StdIn.readDouble();

        Square square2 = new Square(x2, y2, length2); // Creates the second square object with the values provided by the user.

        // Checks if the second square intersects the first and prints the result.
        if (square1.intersects(square2)) {
            System.out.println("It intersects the first square.");
        } else {
            System.out.println("It does not intersect the first square.");
        }

        // Checks if the second square is contained within the first and prints the result.
        if (square1.contains(square2)) {
            System.out.println("It contains the first square.");
        } else {
            System.out.println("It does not contain the first square.");
        }

        // Sets up the drawing canvas to scale between 0 and 1 for both axes, and sets the pen color to blue for the first square, then switches to red for the second square.
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);
        StdDraw.setPenColor(StdDraw.BLUE);
        square1.draw();
        StdDraw.setPenColor(StdDraw.RED);
        square2.draw();
    }
}