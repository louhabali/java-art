package geometrical_shapes;

import java.awt.Color;

public class Rectangle implements Drawable {
    private Point p1, p2;
    private Color color;

    public Rectangle(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.color = new Color(
            (float) Math.random(), 
            (float) Math.random(), 
            (float) Math.random()
        );
    }

    @Override
    public void draw(Displayable displayable) {
        int xsghira = Math.min(p1.x, p2.x);
        int xkbira = Math.max(p1.x, p2.x);
        int ysghira = Math.min(p1.y, p2.y);
        int ykbira = Math.max(p1.y, p2.y);

        for (int x = xsghira; x <= xkbira; x++) {
            displayable.display(x, ysghira, color);
            displayable.display(x, ykbira, color);
        }
        for (int y = ysghira; y <= ykbira; y++) {
            displayable.display(xsghira, y, color);
            displayable.display(xkbira, y, color);
        }
    }

    @Override
    public Color getColor() {
        return color;
    }
}
