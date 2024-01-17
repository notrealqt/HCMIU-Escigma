package items;

import java.io.IOException;
import javax.imageio.ImageIO;

import entities.Entity;
import main.GamePanel;

public class WormHole extends Entity{

    GamePanel gp;
    public WormHole(GamePanel gp, String wormholeType) {
        super(gp);
        this.gp = gp;
        type = type_obstacle;
        name = "WormHole";
        down0 = setUp("/res/objects/"+wormholeType,gp.tileSize, gp.tileSize);

    }  
}
