package object;

import java.io.IOException;
import javax.imageio.ImageIO;

import main.GamePanel;

public class Chest extends SuperObject{
    GamePanel gp;
    public Chest(GamePanel gp) {
        name = "Chest";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/chest.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }  
}