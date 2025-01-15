package introcs.JavaClass;

import edu.princeton.cs.algs4.StdDraw;

public class StdDrawTest {
    public static void main(String[] args) {
        StdDraw.setXscale(0, 10);
        StdDraw.setYscale(0, 10);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.filledRectangle(5, 5, 2, 3);
        StdDraw.text(5, 9, "Test Window");
        StdDraw.show();
    }
}