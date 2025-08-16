package geometrical_shapes;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Image implements Displayable {
    private BufferedImage image;

    public Image(int width, int height) {
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++)
            for (int y = 0; y < height; y++)
                image.setRGB(x, y, Color.BLACK.getRGB());
    }

    public int getWidth() {
        return image.getWidth();
    }

    public int getHeight() {
        return image.getHeight();
    }

    @Override
    public void display(int x, int y, Color color) {
        if (x >= 0 && x < image.getWidth() && y >= 0 && y < image.getHeight()) {
            image.setRGB(x, y, color.getRGB());
        }
    }

    @Override
    public void save(String filePath) {
        try {
            ImageIO.write(image, "png", new File(filePath));
            System.out.println("Image saved to " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
