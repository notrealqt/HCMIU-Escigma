package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class Door extends SuperObject{
    public Door() {
        name = "Door";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/door.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }  
}
