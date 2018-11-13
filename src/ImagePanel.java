import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private BufferedImage image;

    public ImagePanel(BufferedImage image) {
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void paint(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }

    public void loadOriginalImage(File file) {
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createArtWork(String s) {
        if (image == null)
            return;
        try {
            Graphics g = image.getGraphics();
            g.setColor(Color.red);
            g.drawString("Picture speaks thousand words", 50, 50);
            g.drawImage(ImageIO.read(new File(s)), 120, 100, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


//https://www.developer.com/java/data/working-with-images-in-java.html