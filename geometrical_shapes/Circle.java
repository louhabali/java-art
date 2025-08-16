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
        int r = (int)(Math.random() * Math.min(maxX, maxY) / 10);
        return new Circle(p, r);
    }

    @Override
    public void draw(Displayable displayable) {
        int x0 = center.x;
        int y0 = center.y;
        int x = radius;
        int y = 0;
        int err = 0;

        while (x >= y) {
            displayable.display(x0 + x, y0 + y, color);
            displayable.display(x0 + y, y0 + x, color);
            displayable.display(x0 - y, y0 + x, color);
            displayable.display(x0 - x, y0 + y, color);
            displayable.display(x0 - x, y0 - y, color);
            displayable.display(x0 - y, y0 - x, color);
            displayable.display(x0 + y, y0 - x, color);
            displayable.display(x0 + x, y0 - y, color);

            y++;
            if (err <= 0) {
                err += 2*y + 1;
            }
            if (err > 0) {
                x--;
                err -= 2*x + 1;
            }
        }
    }

    @Override
    public Color getColor() {
        return color;
    }
}
