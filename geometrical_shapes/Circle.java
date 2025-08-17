package geometrical_shapes;

import java.awt.Color;

public class Circle implements Drawable {
    private Point center;
    private int radius;
    private Color color;

    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
        this.color = new Color(
            (float) Math.random(), 
            (float) Math.random(), 
            (float) Math.random()
        );
    }

    public static Circle random(int maxX, int maxY) {
        Point p = Point.random(maxX, maxY);
        int r = (int)(Math.random() * Math.min(maxX, maxY));
        return new Circle(p, r);
    }
    private double calculateDistance(double x1, double y1, double x2, double y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public void draw(Displayable img) {
        int cx = center.x;
        int cy = center.y;
        double r = (double) radius;
        int x = cx;
        int y = (int) (cy - r);
        while (y <= cy) {
            double a = Math.abs(calculateDistance(cx, cy, x + 1, y) - r);
            double b = Math.abs(calculateDistance(cx, cy, x, y + 1) - r);
            double c = Math.abs(calculateDistance(cx, cy, x + 1, y + 1) - r);
            double min = Math.min(a, Math.min(b, c));

            if (a == min) {
                x += 1;
            } else if (b == min) {
                y += 1;
            } else if (c == min) {
                x += 1;
                y += 1;
            }
            img.display(x, y, color);
            img.display(x, cy + (cy - y), color);
            img.display(2 * cx - x, y, color);
            img.display(2 * cx - x, cy + (cy - y), color);
        }
    }

    @Override
    public Color getColor() {
        return color;
    }
}
