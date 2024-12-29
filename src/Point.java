public class Point {
    private double x, y, z;

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public double distanceTo(Point q) {
        // Calculates the differences in x, y, and z coordinates.
        double dx = this.x - q.x;
        double dy = this.y - q.y;
        double dz = this.z - q.z;

        // Compute and return the Euclidean distance.
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    // Override the toString method to return a string representation of the point.
    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

    public static void main(String[] args) {
        // Validate the input. Make sure exactly six arguments are provided.
        if (args.length != 6) {
            System.out.println("Please provide six numbers as arguments.");
            return; // Exit the program if the input is invalid.
        }

        try {
            // Parse the six arguments into coordinates for two points.
            double x1 = Double.parseDouble(args[0]);
            double y1 = Double.parseDouble(args[1]);
            double z1 = Double.parseDouble(args[2]);
            double x2 = Double.parseDouble(args[3]);
            double y2 = Double.parseDouble(args[4]);
            double z2 = Double.parseDouble(args[5]);

            // Create two Point objects using the parsed coordinates.
            Point p1 = new Point(x1, y1, z1);
            Point p2 = new Point(x2, y2, z2);

            // Print the points and their Euclidean distance.
            System.out.println("The first point is: " + p1);
            System.out.println("The second point is: " + p2);
            System.out.println("Their Euclidean distance is: " + p1.distanceTo(p2));
        } catch (NumberFormatException e) {
            // The error if the input arguments are not valid numbers.
            System.out.println("Invalid input. Please ensure all arguments are numbers.");
        }
    }
}
