package home;

import javax.imageio.ImageIO;
import java.applet.Applet;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class AppletHomeWork extends Applet {
    @Override
    public void paint(Graphics g) {
        g.drawString("Hello, world", 50, 25);

        final Image image;
        try {
            File pathToFile = new File("image.png");
            image = ImageIO.read(pathToFile);
        } catch (IOException ex) {
            throw new IllegalArgumentException(ex);
        }

        g.drawImage(image, 0, 9, (img, infoflags, x, y, width, height) -> false);


//        sun.misc.Unsafe.getUnsafe();
    }
}
