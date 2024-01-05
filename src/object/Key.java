package object;

import java.io.IOException;
import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class Key extends Entity {

    public Key (GamePanel gp) {
        super(gp);
        name = "Key";
        down0 = setUp("objects/key",gp.tileSize, gp.tileSize);
        description = "["+name+"]\nKey to open door\nWhat do you expect more?";
        /*
        try {
            down0 = ImageIO.read(getClass().getResourceAsStream("key."));
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        
    }
}
