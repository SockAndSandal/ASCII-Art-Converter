import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ASCII {
    private String ramp = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'.";
    private int rampLength = ramp.length();
    private File file;
    private FileWriter writer;
    private Images image;

    ASCII(File file, Images image)
    {
        this.file = file;
        this.image = image;
    }

    public char getRamp(int grayValue)
    {
        char[] temp = ramp.toCharArray();
        return temp[((rampLength - 1) * grayValue / 255)];
    }
    public void writeToFile()
    {
        char[][] temp = new char[image.getImage().getHeight()][image.getImage().getWidth()];
        try {
            writer = new FileWriter(file);
        } catch(IOException e) {
            System.out.println("Problem in ASCII");
            e.printStackTrace();
        }

        for(int i = 0; i < image.getImage().getHeight(); i++) {
            for(int j = 0; j < image.getImage().getWidth(); j++) {

                Pixel pixel = new Pixel(image.getImage(), j, i);
                char c = getRamp(pixel.getGray());
                temp[i][j] = c;
                //System.out.print(temp[i][j]);

            }
            //System.out.println();
        }
        for(char[] s : temp)
        {
            try {
                writer.write(new String(s) + System.lineSeparator());
            } catch (IOException e) {
                System.out.println("Writer is messing up");
                e.printStackTrace();
            }
        }

    }

}
