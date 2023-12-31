package object;

import java.io.IOException;
import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class Door extends Entity{

    public Door(GamePanel gp) {
        super(gp);
        name = "Door";
        down0 = setUp("objects/Door",gp.tileSize, gp.tileSize);
        /*
        try {
            down0 = ImageIO.read(getClass().getResourceAsStream("/res/objects/door.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        collision = true;
        solidArea.x = 0;
        solidArea.y = 16;
        solidArea.width = 48;
        solidArea.height = 32;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }  
}
