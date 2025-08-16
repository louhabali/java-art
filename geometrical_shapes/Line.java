package geometrical_shapes;

import java.awt.Color;

public class Line implements Drawable {
    private Point start, end;
    private Color color;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
        this.color = new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
    }

    public static Line random(int maxX, int maxY) {
        Point p1 = Point.random(maxX, maxY);
        Point p2 = Point.random(maxX, maxY);
        return new Line(p1, p2);
    }

   @Override
    public void draw(Displayable displayable) {
    int dx = end.x - start.x;
    int dy = end.y - start.y;

    int steps = Math.abs(dx);
    if (Math.abs(dy) > steps) {
        steps = Math.abs(dy);
    }

    if (steps == 0) {
        displayable.display(start.x, start.y, color);
        return;
    }

    double x = start.x;
    double y = start.y;

    double xIncrement = dx / (double) steps;
    double yIncrement = dy / (double) steps;

    for (int i = 0; i <= steps; i++) {
        displayable.display((int) Math.round(x), (int) Math.round(y), color);
        x += xIncrement;
        y += yIncrement;
    }
}


    @Override
    public Color getColor() {
        return color;
    }
}
