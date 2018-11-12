import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.opencv.imgcodecs.Imgcodecs;




public class Images {

    private File file;
    private BufferedImage input;

    public Images(File file)
    {
        this.file = file;
        try {
            input = ImageIO.read(file);
        } catch(IOException e) {
            System.out.println("No image was loaded");
            e.printStackTrace();
        }
    }
    public BufferedImage getImage()
    {
        return this.input;
    }
    public void convertToGrayscale()
    {
        String temp = file.getName();
        int beforeExtension = temp.lastIndexOf('.');
        File output = new File(temp.substring(0, beforeExtension) + "-grayed" + temp.substring(beforeExtension));
        for(int i = 0; i < input.getHeight(); i++) {
            for(int j = 0; j < input.getWidth(); j++) {

                Pixel pixel = new Pixel(input, j, i);

                pixel.setGray(input);

            }
        }
        try {
            ImageIO.write(input, "jpg", output);
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void increaseBrightness()
    {
        String t = file.getName();
        int beforeExtension = t.lastIndexOf('.');
        File output = new File(t.substring(0, beforeExtension) + "-brighter" + t.substring(beforeExtension));


        RescaleOp rescale = new RescaleOp(1.2f, 15, null);
        rescale.filter(input, input);

        try {
            System.out.println("Making the new image");
            ImageIO.write(input, "jpg", output);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void increaseContrastGrayed()
    {
        String t = file.getName();
        int beforeExtension = t.lastIndexOf('.');
        File output = new File(t.substring(0, beforeExtension) + "-contrasted-grayed" + t.substring(beforeExtension));

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        Mat source = Imgcodecs.imread(t, Imgcodecs.CV_LOAD_IMAGE_COLOR);

        Imgproc.cvtColor(source, source, Imgproc.COLOR_BGR2GRAY);

        Mat dest = new Mat();

        Imgproc.equalizeHist(source, dest);

        Imgcodecs.imwrite(t.substring(0, beforeExtension) + "-contrasted-grayed" + t.substring(beforeExtension), dest);


        //return output.getName();
    }

}
