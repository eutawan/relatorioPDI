import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Convolution {
    public void convolution(String path, int[][] filter, String pathDestination) throws IOException {
        BufferedImage image = ImageIO.read(new File(path));

        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage filterImage = new BufferedImage(width, height, image.getType());

        int offset = (filter.length - 1) / 2;

        for (int row = offset; row < width - offset; row++) {
            for (int column = offset; column < height - offset; column++) {
                int red = 0, green = 0, blue = 0;

                for (int i = 0; i < filter.length; i++) {
                    for (int j = 0; j < filter.length; j++) {
                        int pixelRow = row + i - offset;
                        int pixelColumn = column + j - offset;

                        if (validPixel(pixelRow, pixelColumn, width, height)) {
                            Color pixelColor = new Color(image.getRGB(pixelRow, pixelColumn));
                            red += pixelColor.getRed() * filter[i][j];
                            green += pixelColor.getGreen() * filter[i][j];
                            blue += pixelColor.getBlue() * filter[i][j];
                        }
                    }
                }

                red = Math.max(0, Math.min(red, 255));
                green = Math.max(0, Math.min(green, 255));
                blue = Math.max(0, Math.min(blue, 255));

                filterImage.setRGB(row, column, new Color(red, green, blue).getRGB());
            }
        }

        ImageIO.write(filterImage, "png", new File(pathDestination));
    }

    public void convolution(String path, double[][] filter, String pathDestination) throws IOException {
        BufferedImage image = ImageIO.read(new File(path));

        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage filterImage = new BufferedImage(width, height, image.getType());

        int offset = (filter.length - 1) / 2;

        for (int row = offset; row < width - offset; row++) {
            for (int column = offset; column < height - offset; column++) {
                int red = 0, green = 0, blue = 0;

                for (int i = 0; i < filter.length; i++) {
                    for (int j = 0; j < filter.length; j++) {
                        int pixelRow = row + i - offset;
                        int pixelColumn = column + j - offset;

                        if (validPixel(pixelRow, pixelColumn, width, height)) {
                            Color pixelColor = new Color(image.getRGB(pixelRow, pixelColumn));
                            red += (int) (pixelColor.getRed() * filter[i][j]);
                            green += (int) (pixelColor.getGreen() * filter[i][j]);
                            blue = (int) (blue + pixelColor.getBlue() * filter[i][j]);
                        }
                    }
                }

                red = Math.max(0, Math.min(red, 255));
                green = Math.max(0, Math.min(green, 255));
                blue = Math.max(0, Math.min(blue, 255));

                filterImage.setRGB(row, column, new Color(red, green, blue).getRGB());
            }
        }

        ImageIO.write(filterImage, "png", new File(pathDestination));
    }

    private static boolean validPixel(int x, int y, int width, int height) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }
}
