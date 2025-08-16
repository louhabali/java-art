package geometrical_shapes;

public class Point  {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
 
    public static Point random(int maxX, int maxY) {
        return new Point((int)(Math.random() * maxX), (int)(Math.random() * maxY));
    }
}
