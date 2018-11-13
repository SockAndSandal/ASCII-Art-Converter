import javafx.application.Application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main  {



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
        Scanner sc = new Scanner(System.in);
      /*  Images first = new Images(new File("apple.jpg"));
        Images second = new Images(new File("apple.jpg"));

        File output = new File("outImg.txt");

        first.convertToGrayscale();
        second.increaseBrightness();

        new Images(new File("apple.jpg")).increaseContrastGrayed();

        ASCII ascii = new ASCII(output, new Images(new File("apple-contrasted-grayed.jpg")));

        ascii.writeToFile(); */
    /*    String s = "me3-brighter.jpg";
        new Main().preProcessDark(s);

        new Main().drawAscii("me3-brighter-contrasted-grayed.jpg"); */
        System.out.println("Hi, what would you like to do today? Please enter a string first");

        String s = sc.next();

        System.out.println("Thank you, we'll now process your string");
        System.out.println("What processing would you like? 1) Facial, 2) Background, 3) light processing(unoptimised)");

        int n = sc.nextInt();

        if(n == 1) {
            new Main().preProcessBright(s);
            new Main().preProcessDark(s.substring(0, s.lastIndexOf('.')) + "-brighter.jpg");
            new Main().drawAscii( s.substring(0, s.lastIndexOf('.')) + "-brighter-contrasted-grayed.jpg");

        }
        else if(n == 2) {
            new Main().preProcessDark(s);
            new Main().drawAscii( s.substring(0, s.lastIndexOf('.')) + "-contrasted-grayed.jpg");
        }
        else if(n == 3) {
            new Main().preProcessBright(s);
            new Main().drawAscii( s.substring(0, s.lastIndexOf('.')) + "-grayed.jpg");
        }
        else {
            System.out.println("There seems to be an error");
        }

        System.out.println(s + " has been processed, please find it in the relevant text file");



    }
}
