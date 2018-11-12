import java.awt.*;
import java.awt.image.BufferedImage;

public class Pixel {

    private int row;
    private int column;
    private int red;
    private int green;
    private int blue;

    public Pixel(BufferedImage input, int row, int column)
    {
        this.row = row;
        this.column = column;

        Color color = new Color(input.getRGB(row, column));

        red = color.getRed();
        green = color.getGreen();
        blue = color.getBlue();
    }
    public int getGray()
    {
        int gray = (int)(red * 0.299) + (int)(green * 0.587) + (int)(blue * 0.114);

        return gray;
    }
    public void setGray(BufferedImage image)
    {
        Color newColor = new Color(this.getGray(), this.getGray(), this.getGray());
        image.setRGB(row, column, newColor.getRGB());

    }
}