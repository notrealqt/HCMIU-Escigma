package object;

import java.io.IOException;
import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;


public class Chest extends Entity{
    public Chest(GamePanel gp) {
        super(gp);
        name = "Chest";
        down0 = setUp("objects/chest");
        /* 
        try {
            down0 = ImageIO.read(getClass().getResourceAsStream("/res/objects/chest.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
    }  
}