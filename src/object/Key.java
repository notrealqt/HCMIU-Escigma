package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class Key extends SuperObject {
    public Key () {
        name = "Key";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/key.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
