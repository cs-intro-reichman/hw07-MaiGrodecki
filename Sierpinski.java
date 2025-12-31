/** Draws the Sierpinski Triangle fractal. */
public class Sierpinski {

    public static void main(String[] args) {
        sierpinski(Integer.parseInt(args[0]));
    }
    public static void sierpinski(int n) {
        StdDraw.setXscale(0.0, 1.0);
        StdDraw.setYscale(0.0, 1.1);

        double x1 = 0.0, y1 = 0.0;
        double x2 = 1.0, y2 = 0.0;
        double x3 = 0.5, y3 = Math.sqrt(3) / 2;
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(x1, y1, x2, y2);
        StdDraw.line(x2, y2, x3, y3);
        StdDraw.line(x3, y3, x1, y1);

        sierpinski(n, x1, x2, x3, y1, y2, y3);
    }

	private static void sierpinski(int n, double x1, double x2, double x3,
		                                 double y1, double y2, double y3) {

        if (n == 0){
			return;
		} 

        double midx12 = (x1 + x2) / 2;
        double midy12 = (y1 + y2) / 2;
        double midx23 = (x2 + x3) / 2;
        double midy23 = (y2 + y3) / 2;
        double midx13 = (x1 + x3) / 2;
        double midy13 = (y1 + y3) / 2;
        StdDraw.line(midx12, midy12, midx23, midy23);
        StdDraw.line(midx23, midy23, midx13, midy13);
        StdDraw.line(midx13, midy13, midx12, midy12);
        sierpinski(n - 1, x1, midx12, midx13, y1, midy12, midy13);
        sierpinski(n - 1, midx12, x2, midx23, midy12, y2, midy23);
        sierpinski(n - 1, midx13, midx23, x3, midy13, midy23, y3);
    }
}
