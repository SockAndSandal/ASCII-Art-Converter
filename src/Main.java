import java.io.File;
import java.io.IOException;

public class Main {

    public String preProcessBright(String s)
    {
        Images first = new Images(new File(s));
        first.convertToGrayscale();
        first.increaseBrightness();

        return (s.substring(0, s.lastIndexOf('.'))) + "-grayed-brighter.jpg";
    }
    public void preProcessDark(String s)
    {
        Images images = new Images(new File(s));
        images.increaseContrastGrayed();

    }
    public void drawAscii(String s)
    {
        int beforeExt = s.lastIndexOf('.');
        File output = new File(s.substring(0, beforeExt) + "-asc.txt");
        try {
           output.createNewFile();
        } catch(IOException e) {
            e.printStackTrace();
        }
        ASCII ascii = new ASCII(output, new Images(new File(s)));
        ascii.writeToFile();
    }
    public static void main(String[] args)
    {
      /*  Images first = new Images(new File("apple.jpg"));
        Images second = new Images(new File("apple.jpg"));

        File output = new File("outImg.txt");

        first.convertToGrayscale();
        second.increaseBrightness();

        new Images(new File("apple.jpg")).increaseContrastGrayed();

        ASCII ascii = new ASCII(output, new Images(new File("apple-contrasted-grayed.jpg")));

        ascii.writeToFile(); */
        String s = "bali.jpg";
        new Main().preProcessBright(s);

        new Main().drawAscii("bali-contrasted-grayed.jpg");



    }
}
