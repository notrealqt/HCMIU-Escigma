package object;

import java.io.IOException;
import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class Boots extends Entity{
    public Boots(GamePanel gp) {
        super(gp);
        name = "Boots";
        down0 = setUp("objects/boots");
        /* 
        try {
            down0 = ImageIO.read(getClass().getResourceAsStream("/res/objects/boots.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
    }  
}
