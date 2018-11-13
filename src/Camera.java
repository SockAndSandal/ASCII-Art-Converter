import com.github.sarxos.webcam.Webcam;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.swing.JFrame;
import com.github.sarxos.webcam.ds.ipcam.IpCamDeviceRegistry;
import com.github.sarxos.webcam.ds.ipcam.IpCamDriver;
import com.github.sarxos.webcam.ds.ipcam.IpCamMode;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import org.opencv.videoio.VideoCapture;
import org.opencv.core.Core;


public class Camera {

    public static void TakePicture(String img)
    {
        Webcam webcam = Webcam.getDefault();

        webcam.open();

        BufferedImage image = webcam.getImage();

        try {
            ImageIO.write(image, "jpg", new File(img));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static {
        Webcam.setDriver(new IpCamDriver());
    }
    public static void streamVideo()
    {
        try {
            IpCamDeviceRegistry.register("Arjun", "http://192.168.0.101:8080", IpCamMode.PUSH);
        } catch (MalformedURLException e) {
            System.out.println("Error in URL");
            e.printStackTrace();
        }
        WebcamPanel panel = new WebcamPanel(Webcam.getWebcams().get(0));
        panel.setFPSLimit(1);

        JFrame f = new JFrame("Live from Arjun's phone");
        f.add(panel);
        f.pack();
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void streamVideoCV()
    {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        VideoCapture ip_cam = new VideoCapture(0);

        ip_cam.open("http://192.168.0.101:8080/video");
    }
    public static void pictureCam()
    {

    }



}
