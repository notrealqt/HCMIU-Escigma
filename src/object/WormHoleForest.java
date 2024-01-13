package object;

import java.io.IOException;
import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class WormHoleForest extends Entity{

    GamePanel gp;
    public WormHoleForest(GamePanel gp) {
        super(gp);
        this.gp = gp;
        type = type_obstacle;
        name = "WormHoleIce";
        down0 = setUp("objects/wormhole_forest",gp.tileSize, gp.tileSize);
        /*
        try {
            down0 = ImageIO.read(getClass().getResourceAsStream("/res/objects/door.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
    }  
}
