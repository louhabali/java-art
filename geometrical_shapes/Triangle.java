package geometrical_shapes;

import java.awt.Color;

public class Triangle implements Drawable {
    private Point a, b, c;
    private Color color;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.color = new Color(
            (float) Math.random(), 
            (float) Math.random(), 
            (float) Math.random()
        );
    }

    @Override
    public void draw(Displayable displayable) {
        drawLine(displayable, a, b);
        drawLine(displayable, b, c);
        drawLine(displayable, c, a);
    }

    public void drawLine(Displayable displayable , Point s , Point e){
    int dx = e.x - s.x;
    int dy = e.y - s.y;

    int steps = Math.abs(dx);
    if (Math.abs(dy) > steps) {
        steps = Math.abs(dy);
    }

    if (steps == 0) {
        displayable.display(s.x, e.y, color);
        return;
    }

    double x = s.x;
    double y = s.y;

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
